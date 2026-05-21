
package CUInventario;

import CUInterfaces.ICUIEntradaProducto;
import GoOrderDTO.DatosReporteEntradaDTO;
import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.RegistroEntradaDTO;
import Interfaces.IEntradaProductoBO;
import Interfaces.IInventarioBO;
import Interfaces.IProductoBO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.example.NegocioException;

/**
 *
 * @author maild
 */
public class CUIEntradaProducto implements ICUIEntradaProducto {

    private static final Logger LOGGER = Logger.getLogger(CUIEntradaProducto.class.getName());
    
    private IEntradaProductoBO entradaProductoBO;
    private IProductoBO productoBO;
    private IInventarioBO inventarioBO;
    
    public CUIEntradaProducto(IEntradaProductoBO entradaProductoBO, IProductoBO productoBO, IInventarioBO inventarioBO) {
        this.entradaProductoBO = entradaProductoBO;
        this.productoBO = productoBO;
        this.inventarioBO = inventarioBO;
    }

    @Override
    public EntradaProductoDTO nuevaEntradaProducto(List<ProductoDTO> listaProductosEntrantes) throws NegocioException {
        try {
            if (listaProductosEntrantes == null || listaProductosEntrantes.isEmpty() ) {
                throw new NegocioException("No fue posible realizar operación. La lista de productos entrantes esta vacia.");
            }
            EntradaProductoDTO nuevaEntrada = new EntradaProductoDTO();                        
            List<RegistroEntradaDTO> listaRegistroEntrada = new ArrayList<>();
            
            int totalProductos = 0;
            for (ProductoDTO p: listaProductosEntrantes) {
                
                ProductoDTO productoVerificado = new ProductoDTO();
                productoVerificado.setId(p.getId());
                                
                ProductoDTO productoExiste = null;
                if (p.getId() != null) {
                    productoExiste = productoBO.obtenerProductoPorId(productoVerificado);
                }
                if (productoExiste == null) {
                    ProductoDTO productoCreado = productoBO.crearProducto(p);                    
                    p.setId(productoCreado.getId());
                    productoExiste = productoCreado;
                }
                
                //Registro de productos - Completos
                RegistroEntradaDTO registro = new RegistroEntradaDTO();
                registro.setIdProducto(p.getId());
                registro.setNombre(p.getNombre());
                registro.setPrecio(p.getPrecio());
                registro.setCantidad(p.getCantidadT());
                registro.setFechaHoraOperacion(LocalDateTime.now());
                listaRegistroEntrada.add(registro);
                
                totalProductos += p.getCantidadT();                
            }
            nuevaEntrada.setCantidadTotalEntradas(totalProductos);
            nuevaEntrada.setRegistroEntrada(listaRegistroEntrada);            
            EntradaProductoDTO nuevaEntradaProdu = entradaProductoBO.nuevaEntradaProducto(nuevaEntrada);
            for (ProductoDTO produSumar: listaProductosEntrantes) {
                inventarioBO.actualizarSumarProductoInventario(produSumar);
            }
            return nuevaEntradaProdu;
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar el registro de la nueva entrada.");
        }
    }

    @Override
    public List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException {
        try {
            return entradaProductoBO.listarEntradasProductos();
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible consultar la lista de entrada de productos.");
        }
    }

    @Override
    public List<DatosReporteEntradaDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        try {
            if (fechaInicio == null) {
                throw new NegocioException("La fecha de inicio no puede quedar vacia.");
            }
            if (fechaFin == null) {
                throw new NegocioException("La fecha final no puede estar vacia.");
            }
            
            if (fechaInicio.isAfter(fechaFin)) {
                throw new NegocioException("Las fechas estan al reves. Corregir orden cronologico.");
            }
            return entradaProductoBO.listarHistorialEntradas(fechaInicio, fechaFin);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar la busqueda con los filtros de fechas especificados.");
        }
    }
}
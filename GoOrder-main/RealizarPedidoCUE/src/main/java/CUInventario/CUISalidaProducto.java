
package CUInventario;

import CUInterfaces.ICUISalidaProducto;
import GoOrderDTO.DatosReporteSalidaDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.RegistroSalidaDTO;
import GoOrderDTO.SalidaProductoDTO;
import Interfaces.IInventarioBO;
import Interfaces.IProductoBO;
import Interfaces.ISalidaProductoBO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.example.NegocioException;

/**
 *
 * @author
 */
public class CUISalidaProducto implements ICUISalidaProducto {

    private static final Logger LOGGER = Logger.getLogger(CUISalidaProducto.class.getName());
        
    private ISalidaProductoBO salidaProductoBO;
    private IProductoBO productoBO;
    private IInventarioBO inventarioBO;
    
    public CUISalidaProducto(ISalidaProductoBO salidaProductoBO, IProductoBO productoBO, IInventarioBO inventarioBO) {
        this.salidaProductoBO = salidaProductoBO;
        this.productoBO = productoBO;
        this.inventarioBO = inventarioBO;
    }
    
    @Override
    public SalidaProductoDTO nuevaSalidaProducto(List<ProductoDTO> listaProductosSalientes) throws NegocioException {
        try {
            if (listaProductosSalientes == null || listaProductosSalientes.isEmpty()) {
                throw new NegocioException("No fue posible realizar operación. La lista de productos salientes esta vacia.");
            }
            SalidaProductoDTO nuevaSalida = new SalidaProductoDTO();
            List<RegistroSalidaDTO> listaRegistroSalida = new ArrayList<>();
            
            int totalSalidaProductos = 0;
            for (ProductoDTO p: listaProductosSalientes) {
                
                ProductoDTO productoVerificacion = new ProductoDTO();
                productoVerificacion.setId(p.getId());
                ProductoDTO productoExiste = productoBO.obtenerProductoPorId(productoVerificacion);
                
                if (productoExiste == null) {
                    throw new NegocioException("No fue posible completar la salida. El producto no existe.");
                }
                if (p.getCantidad() > productoExiste.getCantidad()) {
                    throw new NegocioException("No es posible realizar accion. Stock actual supera a la orden de salida.");
                }
                
                RegistroSalidaDTO productoValido = new RegistroSalidaDTO();                
                productoValido.setIdProducto(p.getId());
                productoValido.setNombre(p.getNombre());
                productoValido.setCantidad(p.getCantidadT());
                productoValido.setFechaHoraOperacion(LocalDateTime.now()); //¿?
                listaRegistroSalida.add(productoValido);
                totalSalidaProductos += p.getCantidadT();
            }
            nuevaSalida.setCantidadTotalSalidas(totalSalidaProductos);
            nuevaSalida.setRegistroSalida(listaRegistroSalida);
            
            SalidaProductoDTO salidaProducto = salidaProductoBO.nuevaSalidaProducto(nuevaSalida);
            for (ProductoDTO produRestar: listaProductosSalientes) {
                inventarioBO.actualizarRestarProductoInventario(produRestar);
            }
            return salidaProducto;
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar el registro de la nueva salida.");
        }
    }

    @Override
    public List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException {
        try {
            return salidaProductoBO.listarSalidaProductos();
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible consultar la lista de salidas de productos.");
        }
    }

    @Override
    public List<DatosReporteSalidaDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
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
            return salidaProductoBO.listarHistorialSalidas(fechaInicio, fechaFin);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar la busqueda con los filtros de fechas especificados.");
        }    
    }   
}

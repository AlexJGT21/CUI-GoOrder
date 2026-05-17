
package CUInterfaces;

import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.SalidaProductoDTO;
import java.time.LocalDate;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface ICUInventario {
    
    //Producto
    public abstract ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException;
    public abstract ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException;
    public abstract ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException;
    public abstract List<ProductoDTO> obtenerProducto(String nombreProducto) throws NegocioException;
    public abstract List<ProductoDTO> listarProductos() throws NegocioException;
    //Inventario
    public abstract ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException;        
    public abstract List<ProductoDTO> obtenerListaProductos() throws NegocioException;
    public abstract List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException;
    //EntradaProducto
    public abstract EntradaProductoDTO nuevaEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException;
    public abstract EntradaProductoDTO actualizarEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException;
    public abstract List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException;
    public abstract List<EntradaProductoDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;
    //SalidaProducto
    public abstract SalidaProductoDTO nuevaSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException;
    public abstract SalidaProductoDTO actualizarSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException;
    public abstract List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException;
    public abstract List<SalidaProductoDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException; 
}
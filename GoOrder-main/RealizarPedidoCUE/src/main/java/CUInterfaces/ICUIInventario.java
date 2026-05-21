
package CUInterfaces;

import GoOrderDTO.ProductoDTO;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author maild
 */
public interface ICUIInventario {
    
    //Inventario
    public abstract ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException;        
    public abstract List<ProductoDTO> obtenerListaProductos() throws NegocioException;
    public abstract List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException;
    public abstract ProductoDTO actualizarSumarProductoInventario(ProductoDTO producto) throws NegocioException;
    public abstract ProductoDTO actualizarRestarProductoInventario(ProductoDTO producto) throws NegocioException;
}

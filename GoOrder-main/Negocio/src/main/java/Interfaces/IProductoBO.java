
package Interfaces;

import GoOrderDTO.ProductoDTO;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author 
 */
public interface IProductoBO {
    
    //-----------------------------------
    public abstract ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException;
    public abstract ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException;
    public abstract ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException;
    public abstract List<ProductoDTO> obtenerProducto(String nombreProducto) throws NegocioException;
    public abstract List<ProductoDTO> listarProductos() throws NegocioException;
    //-----------------------------------    
    public abstract List<ProductoDTO> buscarProducto(String nombreProducto) throws NegocioException;        
}
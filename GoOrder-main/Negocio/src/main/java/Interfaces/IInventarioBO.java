
package Interfaces;

import GoOrderDTO.ProductoDTO;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface IInventarioBO {

    public abstract ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException;        
    public abstract List<ProductoDTO> obtenerListaProductos() throws NegocioException;
    public abstract List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException;
}

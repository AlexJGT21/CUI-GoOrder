
package Interfaces;

import Entidades.Producto;
import GoOrderDTO.ProductoDTO;
import goorderpersistencia.PersistenciaException;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author 
 */
public interface IProductoBO {
    
     //-----------------------------------
    public abstract ProductoDTO crearProducto(ProductoDTO producto) throws PersistenciaException;
    public abstract ProductoDTO actualizarProducto(ProductoDTO producto) throws PersistenciaException;
    public abstract ProductoDTO eliminarProducto(ProductoDTO producto) throws PersistenciaException;
    public abstract List<ProductoDTO> obtenerProducto(ProductoDTO producto) throws PersistenciaException;
    //-----------------------------------
    
    public abstract List<ProductoDTO> buscarProducto(String nombreProducto) throws NegocioException;
    
    public abstract List<ProductoDTO> listarProductos() throws NegocioException;

    
}

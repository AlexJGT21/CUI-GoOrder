
package Interfaces;

import Entidades.Producto;
import goorderpersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersistenciaFachada {
    
    //Producto
    public abstract Producto crearProducto(Producto producto) throws PersistenciaException;
    public abstract Producto actualizarProducto(Producto producto) throws PersistenciaException;
    public abstract Producto eliminarProducto(Producto producto) throws PersistenciaException;
    public abstract List<Producto> obtenerProducto(Producto producto) throws PersistenciaException;
    
    //Inventario
    public abstract List<Producto> obtenerListaProductos() throws PersistenciaException;
    public abstract List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException;
    
}
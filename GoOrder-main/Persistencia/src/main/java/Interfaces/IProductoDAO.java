
package Interfaces;

import Entidades.Producto;
import goorderpersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author
 */

/**
 * Este es un producto que tiene "solo metodos"
 */

public interface IProductoDAO {
    
    //-----------------------------------
    public abstract Producto crearProducto(Producto producto) throws PersistenciaException;
    public abstract Producto actualizarProducto(Producto producto) throws PersistenciaException;
    public abstract Producto eliminarProducto(Producto producto) throws PersistenciaException;
    public abstract List<Producto> obtenerProducto(String nombreProducto) throws PersistenciaException;
    public abstract List<Producto> listarProductos() throws PersistenciaException;
    public abstract Producto obtenerProductoPorId(Producto producto) throws PersistenciaException;
    //-----------------------------------    
    public abstract List<Producto> buscarProducto(String nombreProducto) throws PersistenciaException;        
}
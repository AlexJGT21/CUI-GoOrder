
package goorderpersistencia;

import Entidades.Producto;
import Interfaces.IInventarioDAO;
import java.util.List;

/**
 *
 * @author maild
 */
public class InventarioMemoriaDAO implements IInventarioDAO {

    private List<Producto> productos;       
    
    @Override
    public List<Producto> obtenerListaProductos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

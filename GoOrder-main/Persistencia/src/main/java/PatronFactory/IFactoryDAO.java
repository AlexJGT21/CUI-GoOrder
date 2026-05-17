
package PatronFactory;

import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioDAO;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaProductoDAO;

/**
 *
 * @author 
 */
/**
 * 
 * Estos es un creador
 */

public interface IFactoryDAO {
    
    //Estos son creadores concretos
    //Al ser interfaces de desacopla al ser solo interfaces
    //No sabemos quien las implementaI
    public abstract IProductoDAO crearProductosDAO();
    public abstract IInventarioDAO crearInventarioDAO();
    public abstract IEntradaProductoDAO crearEntreadaProductoDAO();
    public abstract ISalidaProductoDAO crearSalidaProductoDAO();
}
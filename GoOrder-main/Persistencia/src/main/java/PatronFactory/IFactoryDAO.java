
package PatronFactory;

import Interfaces.IInventarioDAO;
import Interfaces.IProductoDAO;

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
}
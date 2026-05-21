
package PatronFactory;

import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioDAO;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaProductoDAO;
import goorderpersistencia.EntradaProductoMongoDAO;
import goorderpersistencia.InventarioMongoDAO;
import goorderpersistencia.ProductosMongoDAO;
import goorderpersistencia.SalidaProductoMongoDAO;

/**
 *
 * @author
 */
public class FactoryDataBaseDAOs implements IFactoryDAO {

    @Override
    public IProductoDAO crearProductosDAO() {
        return new ProductosMongoDAO();
    }

    @Override
    public IInventarioDAO crearInventarioDAO() {
        return new InventarioMongoDAO();
    }

    @Override
    public IEntradaProductoDAO crearEntreadaProductoDAO() {
        return new EntradaProductoMongoDAO();
    }

    @Override
    public ISalidaProductoDAO crearSalidaProductoDAO() {
        return new SalidaProductoMongoDAO();
    }    
}

package PatronFactory;

import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioDAO;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaProductoDAO;
import goorderpersistencia.EntradaProductoMemoryDAO;
import goorderpersistencia.InventarioMemoryDAO;
import goorderpersistencia.ProductosMemoryDAO;
import goorderpersistencia.SalidaProductoDAO;

/**
 *
 * @author 
 */
public class FactoryMemoriaDAOs implements IFactoryDAO {

    /**
     * Esta clase es la creadora concreta
     * La que crea los objetos
     * Tengo una interface solo tiene metodos, pero no sabe quien la implementa
     * En el return new Le especifico que me va a crear
     * @return 
     */    
    
    /**
     * Este es un creador concreto de una interfaz, pero como no sabemos quien la implementa le ponemos la interfaz
     * Le ponemos la interfaz y abajo le indicamos quien la implementa
     * Ya que la interfa no conoce quien la implementa, esta solo tiene metodos
     * @return 
     */
    @Override
    public IProductoDAO crearProductosDAO() {
        /**
         * Aqui le decimos que queremos crear, es decir, de la interfaz
         * La clase que implementa la interfaz queremos crear una clase de "ProductosMemoriaDAO"
         * que es la que implementa nuestra interfaz "IProductoDAO = Producto"
         */
        return new ProductosMemoryDAO(); //ProductosMemoriaDAO = Producto concretos
    }    

    @Override
    public IInventarioDAO crearInventarioDAO() {
        return new InventarioMemoryDAO();
    }

    @Override
    public IEntradaProductoDAO crearEntreadaProductoDAO() {
        return new EntradaProductoMemoryDAO();
    }

    @Override
    public ISalidaProductoDAO crearSalidaProductoDAO() {
        return new SalidaProductoDAO();
    }    
}
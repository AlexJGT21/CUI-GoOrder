
package Main;

import CUInterfaces.CUInventario;
import CUInterfaces.ICUInventario;
import Control.Control;
import Interfaces.ICarritoBO;
import Interfaces.ICarritoDAO;
import Interfaces.IDescuentosBO;
import Interfaces.IDescuentosDAO;
import Interfaces.IEntradaProductoBO;
import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioBO;
import Interfaces.IInventarioDAO;
import Interfaces.IProductoBO;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaProductoBO;
import Interfaces.ISalidaProductoDAO;
import Interfaces.IServicioBanco;
import goorderpersistencia.CarritoDAO;
import goorderpersistencia.DescuentosDAO;
import goorderpersistencia.EntradaProductoMemoryDAO;
import goorderpersistencia.InventarioMemoryDAO;
import goorderpersistencia.ProductosMemoryDAO;
import goorderpersistencia.SalidaProductoDAO;
import org.example.CarritoBO;
import org.example.ConectorBanco;
import org.example.DescuentosBO;
import org.example.EntradaProductoBO;
import org.example.InventarioBO;
import org.example.ProductoBO;
import org.example.SalidaProductoBO;
import org.itson.realizarpedidocue.IRealizarPedidoCUE;
import org.itson.realizarpedidocue.RealizarPedidoCUE;

/**
 *
 * @author 
 */

public class Main {    
    public static void main(String[] args) {       
        IDescuentosDAO descuentosDAO = new DescuentosDAO();
        IDescuentosBO descuentosBO = new DescuentosBO(descuentosDAO);
        ICarritoDAO carritoDAO = new CarritoDAO();
        ICarritoBO carritoBO = new CarritoBO(carritoDAO,descuentosBO);
        IServicioBanco bancoService = new ConectorBanco();
        
        //IRealizarPedidoCUE realizarPedido = new RealizarPedidoCUE(productoBO,carritoBO,bancoService);
        //-------------------------------------------------------------------------------------------
        IProductoDAO productoDAO = new ProductosMemoryDAO();
        IProductoBO productoBO = new ProductoBO(productoDAO);
        
        IInventarioDAO inventarioDAO = new InventarioMemoryDAO();
        IInventarioBO inventarioBO = new InventarioBO(inventarioDAO);
        
        IEntradaProductoDAO entradaDAO = new EntradaProductoMemoryDAO();
        IEntradaProductoBO entradaBO = new EntradaProductoBO(entradaDAO);
        
        ISalidaProductoDAO salidaDAO = new SalidaProductoDAO();
        ISalidaProductoBO salidaBO = new SalidaProductoBO(salidaDAO);
        
        ICUInventario inventarioCU = new CUInventario(productoBO, (InventarioBO) inventarioBO, entradaBO, salidaBO);
        //Control control = new Control(realizarPedido);
        
        Control control = new Control(inventarioCU);
        control.mostrarGestionProductosFORM();
    }    
}
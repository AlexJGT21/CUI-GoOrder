
package Main;

import CUInterfaces.ICUIEntradaProducto;
import CUInterfaces.ICUIInventario;
import CUInterfaces.ICUIProducto;
import CUInterfaces.ICUISalidaProducto;
import CUInventario.CUIEntradaProducto;
import CUInventario.CUIInventario;
import CUInventario.CUIProducto;
import CUInventario.CUISalidaProducto;
import Control.Control;
import Interfaces.IEntradaProductoBO;
import Interfaces.IInventarioBO;
import Interfaces.IPersistenciaFachada;
import Interfaces.IProductoBO;
import Interfaces.ISalidaProductoBO;
import PatronFactory.FactoryDataBaseDAOs;
import PatronFactory.IFactoryDAO;
import goorderpersistencia.PersistenciaFachada;
import org.example.EntradaProductoBO;
import org.example.InventarioBO;
import org.example.ProductoBO;
import org.example.SalidaProductoBO;

/**
 *
 * @author 
 */
public class MainCUI {

    public static void main(String[] args) {
        
        IFactoryDAO factoryDAO = new FactoryDataBaseDAOs();
        IPersistenciaFachada fachadaPersistencia = new PersistenciaFachada(factoryDAO);
        
        IProductoBO productoBO = new ProductoBO(fachadaPersistencia);        
        IInventarioBO inventarioBO = new InventarioBO(fachadaPersistencia);        
        IEntradaProductoBO entradaBO = new EntradaProductoBO(fachadaPersistencia);        
        ISalidaProductoBO salidaBO = new SalidaProductoBO(fachadaPersistencia);
        
        ICUIProducto casoProducto = new CUIProducto(productoBO);
        ICUIInventario casoInventario = new CUIInventario(inventarioBO);
        ICUIEntradaProducto casoEntrada = new CUIEntradaProducto(entradaBO, productoBO, inventarioBO);
        ICUISalidaProducto casoSalida = new CUISalidaProducto(salidaBO, productoBO, inventarioBO);
        
        Control control1 = new Control(casoProducto, casoInventario, casoEntrada, casoSalida);
        control1.mostrarGestionProductosFORM();        
    }   
}
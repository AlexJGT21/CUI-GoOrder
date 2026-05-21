
package Main;

import Control.Control;
import Interfaces.ICarritoBO;
import Interfaces.ICarritoDAO;
import Interfaces.IDescuentosBO;
import Interfaces.IDescuentosDAO;
import Interfaces.IPersistenciaFachada;
import Interfaces.IProductoBO;
import Interfaces.IServicioBanco;
import PatronFactory.FactoryDataBaseDAOs;
import PatronFactory.IFactoryDAO;
import goorderpersistencia.CarritoDAO;
import goorderpersistencia.DescuentosDAO;
import goorderpersistencia.PersistenciaFachada;
import org.example.CarritoBO;
import org.example.ConectorBanco;
import org.example.DescuentosBO;
import org.example.ProductoBO;
import org.itson.realizarpedidocue.IRealizarPedidoCUE;
import org.itson.realizarpedidocue.RealizarPedidoCUE;

/**
 *
 * @author 
 */

public class MainCUB {
    public static void main(String[] args) {
        
        IFactoryDAO factoryDAO = new FactoryDataBaseDAOs();
        IPersistenciaFachada fachadaPersistencia = new PersistenciaFachada(factoryDAO);       
        IProductoBO productoBO = new ProductoBO(fachadaPersistencia); 
        IDescuentosDAO descuentosDAO = new DescuentosDAO();
        IDescuentosBO descuentosBO = new DescuentosBO(descuentosDAO);
        ICarritoDAO carritoDAO = new CarritoDAO();
        ICarritoBO carritoBO = new CarritoBO(carritoDAO,descuentosBO);
        IServicioBanco bancoService = new ConectorBanco();
        
        IRealizarPedidoCUE realizarPedido = new RealizarPedidoCUE(productoBO, carritoBO, bancoService);
        Control control = new Control(realizarPedido);
        control.mostrarInicio();
    }    
}
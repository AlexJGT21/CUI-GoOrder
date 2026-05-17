
package goorderpersistencia;

import Entidades.EntradaProducto;
import Entidades.Producto;
import Entidades.SalidaProducto;
import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioDAO;
import Interfaces.IPersistenciaFachada;
import Interfaces.IProductoDAO;
import PatronFactory.IFactoryDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public class PersistenciaFachada implements IPersistenciaFachada {
    
    //Interfaces
    private IProductoDAO productoDAO;
    private IInventarioDAO inventarioDAO;
    private IEntradaProductoDAO entradaProductoDAO;
    
//    public PersistenciaFachada() {
//        // temporal
//        IFactoryDAO factory = new FactoryMemoriaDAOs();
//        this.productoDAO = factory.crearProductosDAO();
//        this.inventarioDAO = factory.crearInventarioDAO();
//    }
    
    /**
     * Aquí tenemos la Factory, pero aun sin hacer nada     
     * @param factory
     */
    public PersistenciaFachada(IFactoryDAO factory) {
        // BOs manden Fabrica cuando ocupan
        //Aquí empieza la construccion       
        //De nuestra factory, queremos que nos construya un productoDAO, este caso es una intefaz
        this.productoDAO = factory.crearProductosDAO();
        //Y ese crearProductoDAO tiene ya un producto concreto creado que es la DAO de memoria de productos
        //No sabemos quien lo implementa (this.productoDAO), solo que es una clase que cumple la implementacion (crearProductosDAO)
        this.inventarioDAO = factory.crearInventarioDAO();
        this.entradaProductoDAO = factory.crearEntreadaProductoDAO();
    }

    //Producto
    
    @Override
    public Producto crearProducto(Producto producto) throws PersistenciaException {
        return this.productoDAO.crearProducto(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        return this.productoDAO.actualizarProducto(producto);
    }

    @Override
    public Producto eliminarProducto(Producto producto) throws PersistenciaException {
        return this.productoDAO.eliminarProducto(producto);
    }

    @Override
    public List<Producto> obtenerProducto(String nombreProducto) throws PersistenciaException {
        return this.productoDAO.obtenerProducto(nombreProducto);
    }
    
    @Override
    public List<Producto> listarProductos() throws PersistenciaException {
        return this.productoDAO.listarProductos();
    }

    //Inventario
    
    @Override
    public List<Producto> obtenerListaProductos() throws PersistenciaException {
        return this.inventarioDAO.obtenerListaProductos();
    }

    @Override
    public List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException {
        return this.inventarioDAO.listarProductosFiltros(nombre, cantidad);
    }

    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        return this.inventarioDAO.agregarProducto(producto);
    }
    
    //Entrada productos

    @Override
    public EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EntradaProducto actualizarEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntradaProducto> listarEntradasProducotos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntradaProducto> listarHistorialEntradas(LocalDate inicio, LocalDate fin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Salida productos

    @Override
    public SalidaProducto nuevaSalidaProducto(SalidaProducto entradaProducto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SalidaProducto actualizarSalidaProducto(SalidaProducto entradaProducto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SalidaProducto> listarSalidaProductos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SalidaProducto> listarHistorialSalidas(LocalDate inicio, LocalDate fin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
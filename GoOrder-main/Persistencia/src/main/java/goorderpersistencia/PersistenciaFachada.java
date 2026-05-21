
package goorderpersistencia;

import DTOSPersistencia.DatosReporteEntrada;
import DTOSPersistencia.DatosReporteSalida;
import Entidades.EntradaProducto;
import Entidades.Producto;
import Entidades.SalidaProducto;
import Interfaces.IEntradaProductoDAO;
import Interfaces.IInventarioDAO;
import Interfaces.IPersistenciaFachada;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaProductoDAO;
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
    private ISalidaProductoDAO salidaProductoDAO;
    
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
        this.salidaProductoDAO = factory.crearSalidaProductoDAO();
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
    
    @Override
    public Producto obtenerProductoPorId(Producto producto) throws PersistenciaException {
        return this.productoDAO.obtenerProductoPorId(producto);
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
    
    @Override
    public Producto actualizarSumarProductoInventario(Producto producto) throws PersistenciaException {
        return this.inventarioDAO.actualizarSumarProductoInventario(producto);
    }
    
    @Override
    public Producto actualizarRestarProductoInventario(Producto producto) throws PersistenciaException {
        return this.inventarioDAO.actualizarRestarProductoInventario(producto);
    }
    
    //Entrada productos

    @Override
    public EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        return this.entradaProductoDAO.nuevaEntradaProducto(entradaProducto);
    }

    @Override
    public List<EntradaProducto> listarEntradasProductos() throws PersistenciaException {
        return this.entradaProductoDAO.listarEntradasProductos();
    }

    @Override
    public List<DatosReporteEntrada> listarHistorialEntradas(LocalDate inicio, LocalDate fin) throws PersistenciaException {
        return this.entradaProductoDAO.listarHistorialEntradas(inicio, fin);
    }
    
    //Salida productos

    @Override
    public SalidaProducto nuevaSalidaProducto(SalidaProducto entradaProducto) throws PersistenciaException {
        return this.salidaProductoDAO.nuevaSalidaProducto(entradaProducto);
    }

    @Override
    public List<SalidaProducto> listarSalidaProductos() throws PersistenciaException {
        return this.salidaProductoDAO.listarSalidaProductos();
    }

    @Override
    public List<DatosReporteSalida> listarHistorialSalidas(LocalDate inicio, LocalDate fin) throws PersistenciaException {
        return this.salidaProductoDAO.listarHistorialSalidas(inicio, fin);
    }   
}
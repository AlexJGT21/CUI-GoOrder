
package Interfaces;

import DTOSPersistencia.DatosReporteEntrada;
import DTOSPersistencia.DatosReporteSalida;
import Entidades.EntradaProducto;
import Entidades.Producto;
import Entidades.SalidaProducto;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersistenciaFachada {
    
    //Producto
    public abstract Producto crearProducto(Producto producto) throws PersistenciaException;
    public abstract Producto actualizarProducto(Producto producto) throws PersistenciaException;
    public abstract Producto eliminarProducto(Producto producto) throws PersistenciaException;
    public abstract List<Producto> obtenerProducto(String nombreProducto) throws PersistenciaException;
    public abstract List<Producto> listarProductos() throws PersistenciaException;
    public abstract Producto obtenerProductoPorId(Producto producto) throws PersistenciaException;
    
    //Inventario
    public abstract List<Producto> obtenerListaProductos() throws PersistenciaException;
    public abstract List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException;
    public abstract Producto agregarProducto(Producto producto) throws PersistenciaException;
    public abstract Producto actualizarSumarProductoInventario(Producto producto) throws PersistenciaException;
    public abstract Producto actualizarRestarProductoInventario(Producto producto) throws PersistenciaException;

    //Entrada producto
    public abstract EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException;
    public abstract List<EntradaProducto> listarEntradasProductos() throws PersistenciaException;
    public abstract List<DatosReporteEntrada> listarHistorialEntradas(LocalDate inicio, LocalDate fin) throws PersistenciaException;  
    
    //Salida producto
    public abstract SalidaProducto nuevaSalidaProducto(SalidaProducto entradaProducto) throws PersistenciaException;
    public abstract List<SalidaProducto> listarSalidaProductos() throws PersistenciaException;
    public abstract List<DatosReporteSalida> listarHistorialSalidas(LocalDate inicio, LocalDate fin) throws PersistenciaException;
    
}
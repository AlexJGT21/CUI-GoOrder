
package Interfaces;

import Entidades.Producto;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public interface IInventarioDAO {
    
    public abstract List<Producto> obtenerListaProductos() throws PersistenciaException;
    public abstract List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException;
    //public abstract List<Producto> listarProductosPeriodoFechas(LocalDate inicio, LocalDate fin) throws PersistenciaException;
}

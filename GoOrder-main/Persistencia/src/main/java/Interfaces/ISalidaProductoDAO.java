
package Interfaces;

import Entidades.SalidaProducto;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public interface ISalidaProductoDAO {
    
    public abstract SalidaProducto nuevaSalidaProducto(SalidaProducto salidaProducto) throws PersistenciaException;
    public abstract SalidaProducto actualizarSalidaProducto(SalidaProducto salidaProducto) throws PersistenciaException;
    public abstract List<SalidaProducto> listarSalidaProductos() throws PersistenciaException;
    public abstract List<SalidaProducto> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException;      
}
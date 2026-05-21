
package Interfaces;

import DTOSPersistencia.DatosReporteSalida;
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
    public abstract List<SalidaProducto> listarSalidaProductos() throws PersistenciaException;
    public abstract List<DatosReporteSalida> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException;      
}
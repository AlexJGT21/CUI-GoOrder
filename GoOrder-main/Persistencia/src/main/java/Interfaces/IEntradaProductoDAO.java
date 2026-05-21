
package Interfaces;

import DTOSPersistencia.DatosReporteEntrada;
import Entidades.EntradaProducto;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author
 */
public interface IEntradaProductoDAO {
    
    public abstract EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException;
    public abstract List<EntradaProducto> listarEntradasProductos() throws PersistenciaException;
    public abstract List<DatosReporteEntrada> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException;    
}

package goorderpersistencia;

import DTOSPersistencia.DatosReporteSalida;
import Entidades.RegistroSalida;
import Entidades.SalidaProducto;
import Interfaces.ISalidaProductoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class SalidaProductoMemoryDAO implements ISalidaProductoDAO {

    private static final Logger LOGGER = Logger.getLogger(SalidaProductoMemoryDAO.class.getName());    
    private List<SalidaProducto> salidaProductos;
    
    public SalidaProductoMemoryDAO() {
        salidaProductos = new ArrayList<>();
    }

    @Override
    public SalidaProducto nuevaSalidaProducto(SalidaProducto salidaProducto) throws PersistenciaException {
        try {
            if (salidaProducto == null) {
                throw new PersistenciaException("Error al registrar salida de producto.");
            }
            salidaProductos.add(salidaProducto);
            return salidaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al registrar nueva salida de productos.");            
        }
    }

    @Override
    public List<SalidaProducto> listarSalidaProductos() throws PersistenciaException {
        try {
            if (salidaProductos.isEmpty()) {
                throw new PersistenciaException("Error: la lista esta vacia.");
            } else {
                return salidaProductos;
            }            
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos.", e);
        }
    }

    //--METODO INHABILITADO MOMENTANEAMENTE
    @Override
    public List<DatosReporteSalida> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<SalidaProducto> listaHistorialSalida = new ArrayList<>();
        try {
            if (salidaProductos.isEmpty()) {
                throw new PersistenciaException("Error: No existen productos para consultar historial.");
            }
            
            for (SalidaProducto salidaProdu: salidaProductos) {
                boolean existeRegistro = false;
                
                for (RegistroSalida registroEntrada: salidaProdu.getRegistroSalida()) {
                    LocalDate fechaOperacion = registroEntrada.getFechaHoraOperacion().toLocalDate();
                    
                    if (!fechaOperacion.isBefore(fechaInicio) && !fechaOperacion.isAfter(fechaFin)) {
                        existeRegistro = true;
                        break;
                    }
                }
                if (existeRegistro) {
                 //   listaHistorialSalida.add(salidaProdu);
                }
            }
            //return listaHistorialSalida;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al visualizar historial de entradas.", e);
        }
        return null;
    }    
}
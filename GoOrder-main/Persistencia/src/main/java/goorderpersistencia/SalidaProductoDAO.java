
package goorderpersistencia;

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
public class SalidaProductoDAO implements ISalidaProductoDAO {

    private static final Logger LOGGER = Logger.getLogger(SalidaProductoDAO.class.getName());    
    private List<SalidaProducto> salidaProductos;
    
    public SalidaProductoDAO() {
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
    public SalidaProducto actualizarSalidaProducto(SalidaProducto salidaProducto) throws PersistenciaException {
        try {
            if (salidaProductos.isEmpty()) {
                throw new PersistenciaException("Error: No existen productos para realizar actualización");
            }
            if (salidaProductos == null && salidaProducto.getId() == null) {
                throw new PersistenciaException("Error al actualizar salida de producto.");
            }
            
            for (SalidaProducto salidaProdu: salidaProductos) {
                if (salidaProdu.getId().equals(salidaProducto.getId())) {
                    if (salidaProducto.getRegistroSalida() != null && !salidaProducto.getRegistroSalida().isEmpty()) {
                        salidaProdu.getRegistroSalida().add(salidaProducto.getRegistroSalida().get(0));
                    }
                    
                    int total = 0;
                    for (RegistroSalida registroSalida: salidaProdu.getRegistroSalida()) {
                        total += registroSalida.getCantidad();
                    }
                    salidaProdu.setCantidadTotalSalidas(total);
                    return salidaProdu;
                }
            }            
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al actualizar salida de producto", e);
        }
        return null;
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

    @Override
    public List<SalidaProducto> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<SalidaProducto> listaHistorialEntradas = new ArrayList<>();
        try {
            if (salidaProductos.isEmpty()) {
                throw new PersistenciaException("Error: No existen productos para consultar historial.");
            }
            
            for (SalidaProducto entradaProdu: salidaProductos) {
                boolean existeRegistro = false;
                
                for (RegistroSalida registroEntrada: entradaProdu.getRegistroSalida()) {
                    LocalDate fechaOperacion = registroEntrada.getFechaHoraOperacion().toLocalDate();
                    
                    if (!fechaOperacion.isBefore(fechaInicio) && !fechaOperacion.isAfter(fechaFin)) {
                        existeRegistro = true;
                        break;
                    }
                }
                if (existeRegistro) {
                    listaHistorialEntradas.add(entradaProdu);
                }
            }
            return listaHistorialEntradas;            
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al visualizar historial de entradas.", e);
        }
    }    
}
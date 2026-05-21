
package goorderpersistencia;

import DTOSPersistencia.DatosReporteEntrada;
import Entidades.EntradaProducto;
import Entidades.RegistroEntrada;
import Interfaces.IEntradaProductoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class EntradaProductoMemoryDAO implements IEntradaProductoDAO {

    private static final Logger LOGGER = Logger.getLogger(EntradaProductoMemoryDAO.class.getName());
    private List<EntradaProducto> entradaProductos;
    
    public EntradaProductoMemoryDAO() {
        entradaProductos = new ArrayList<>();
    }    
    
    @Override
    public EntradaProducto nuevaEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        try {
            if (entradaProducto == null || entradaProducto.getId() == null) {
                throw new PersistenciaException("Error al registrar entrada de producto.");
            }
            entradaProductos.add(entradaProducto);
            return entradaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al registrar nueva entrada de producto.", e);
        }
    }

    @Override
    public List<EntradaProducto> listarEntradasProductos() throws PersistenciaException {
        try {
            if (entradaProductos.isEmpty()) {
                throw new PersistenciaException("Error: la lista esta vacia.");
            } else { //else porque si otra vez xd
                return entradaProductos;
            }            
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos.", e);
        }
    }

    //--METODO INHABILITADO MOMENTANEAMENTE
    @Override
    public List<DatosReporteEntrada> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<DatosReporteEntrada> listaHistorialEntradas = new ArrayList<>();
        try {
            if (entradaProductos.isEmpty()) {
                throw new PersistenciaException("Error: No existen productos para consultar historial.");
            }
            
            for (EntradaProducto entradaProdu: entradaProductos) {
                boolean existeRegistro = false;
                
                for (RegistroEntrada registroEntrada: entradaProdu.getRegistroEntrada()) {
                    LocalDate fechaOperacion = registroEntrada.getFechaHoraOperacion().toLocalDate();
                    
                    if (!fechaOperacion.isBefore(fechaInicio) && !fechaOperacion.isAfter(fechaFin)) {
                        existeRegistro = true;
                        break;
                    }
                }
                if (existeRegistro) {
                    //listaHistorialEntradas.add(e);
                }
            }
            return listaHistorialEntradas;            
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al visualizar historial de entradas.", e);
        }
    }    
}
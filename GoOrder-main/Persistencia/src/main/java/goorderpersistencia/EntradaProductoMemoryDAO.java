
package goorderpersistencia;

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
    public EntradaProducto actualizarEntradaProducto(EntradaProducto entradaProducto) throws PersistenciaException {
        try {
            //Validaciones
            if (entradaProductos.isEmpty()) {
                throw new PersistenciaException("Error: No existen productos para realizar actualización.");
            }
            if (entradaProducto == null || entradaProducto.getId() == null) {
                throw new PersistenciaException("Error al actualizar entrada de producto.");
            }
            
            //Recorre los productos
            for (EntradaProducto entradaProdu: entradaProductos) { //AQUÍ ARRIBA
                //Los compara para ver si es la entrada correcta
                if (entradaProdu.getId().equals(entradaProducto.getId())) {
                    
                    //Obtiene el registro tomado en pantalla (UI)
                    RegistroEntrada registroEntrada = entradaProducto.getRegistroEntrada().get(0);
                    //Añade un nuevo registro
                    entradaProdu.getRegistroEntrada().add(registroEntrada);
                    
                    int total = 0;
                    //Recorremos los registros que tenemos arriba
                    for (RegistroEntrada regEntrada: entradaProdu.getRegistroEntrada()) {
                        //Por cada entrada, vamos obteniendo la cantidad, y lavamso acumulando
                        total += regEntrada.getCantidad();
                    }
                    //Luego al registro de entrada nuevo, mas lo que tenemos le seteamos la nueva cantidad global
                    entradaProdu.setCantidadTotalProductos(total);
                    return entradaProdu;
                }
            }
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al actualizar producto y registrar su entrada.", e);
        }
        return null;
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

    @Override
    public List<EntradaProducto> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        List<EntradaProducto> listaHistorialEntradas = new ArrayList<>();
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
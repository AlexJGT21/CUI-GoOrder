
package org.example;

import Entidades.EntradaProducto;
import GoOrderDTO.EntradaProductoDTO;
import Interfaces.IEntradaProductoBO;
import Interfaces.IEntradaProductoDAO;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class EntradaProductoBO implements IEntradaProductoBO {

    private static final Logger LOGGER = Logger.getLogger(EntradaProductoBO.class.getName());        
    private IEntradaProductoDAO entradaProductoDAO;
    
    public EntradaProductoBO(IEntradaProductoDAO entradaProductoDAO) {
        this.entradaProductoDAO = entradaProductoDAO;
    }

    @Override
    public EntradaProductoDTO nuevaEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException {
        try {
            EntradaProducto entradaProdu = Adapters.AdapterEntradaProducto.toEntity(entradaProducto);
            entradaProductoDAO.nuevaEntradaProducto(entradaProdu);
            return entradaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al registrar nueva entrada de producto.", e);
        }
    }

    @Override
    public EntradaProductoDTO actualizarEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException {
        try {
            EntradaProducto entradaProdu = Adapters.AdapterEntradaProducto.toEntity(entradaProducto);
            entradaProductoDAO.actualizarEntradaProducto(entradaProdu);
            return entradaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar entrada de producto.", e);
        }
    }

    @Override
    public List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException {
        try {
            List<EntradaProducto> lista = entradaProductoDAO.listarEntradasProductos();
            List<EntradaProductoDTO> listaDTO = new ArrayList<>();
            
            for (EntradaProducto entradaEntity: lista) {
                listaDTO.add(Adapters.AdapterEntradaProducto.toDto(entradaEntity));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar productos.", e);
        }
    }

    @Override
    public List<EntradaProductoDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        try {
            List<EntradaProducto> lista = entradaProductoDAO.listarHistorialEntradas(fechaInicio, fechaFin);
            List<EntradaProductoDTO> listaDTO = new ArrayList<>();
            
            for (EntradaProducto entradaEntity: lista) {
                listaDTO.add(Adapters.AdapterEntradaProducto.toDto(entradaEntity));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar historial de entradas.");
        }
    }
}

package org.example;

import Entidades.SalidaProducto;
import GoOrderDTO.SalidaProductoDTO;
import Interfaces.ISalidaProductoBO;
import Interfaces.ISalidaProductoDAO;
import goorderpersistencia.PersistenciaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class SalidaProductoBO implements ISalidaProductoBO {

    private static final Logger LOGGER = Logger.getLogger(SalidaProductoBO.class.getName());
    private ISalidaProductoDAO salidaDAO;
    
    public SalidaProductoBO(ISalidaProductoDAO salidaDAO) {
        this.salidaDAO = salidaDAO;
    }
    
    @Override
    public SalidaProductoDTO nuevaSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException {
        try {
            SalidaProducto salida = Adapters.AdapterSalidaProducto.toEntity(salidaProducto);
            salidaDAO.nuevaSalidaProducto(salida);
            return salidaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al registrar la nueva salida del producto.");
        }
    }

    @Override
    public SalidaProductoDTO actualizarSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException {
        try {
            SalidaProducto salida = Adapters.AdapterSalidaProducto.toEntity(salidaProducto);
            salidaDAO.actualizarSalidaProducto(salida);
            return salidaProducto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al registrar la nueva salida del producto.");
        }
    }

    @Override
    public List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException {
        try {
            List<SalidaProducto> lista = salidaDAO.listarSalidaProductos();
            List<SalidaProductoDTO> listaDTO = new ArrayList<>();
            
            for (SalidaProducto salidaProducto: lista) {
                listaDTO.add(Adapters.AdapterSalidaProducto.toDto(salidaProducto));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar productos.", e);
        }    
    }

    @Override
    public List<SalidaProductoDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        try {
            List<SalidaProducto> lista = salidaDAO.listarHistorialSalidas(fechaInicio, fechaFin);
            List<SalidaProductoDTO> listaDTO = new ArrayList<>();
            
            for (SalidaProducto salidaProducto: lista) {
                listaDTO.add(Adapters.AdapterSalidaProducto.toDto(salidaProducto));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar productos.", e);
        }    
    }    
}

package org.example;

import Adapters.DtoEntityProduct;
import Entidades.Producto;
import GoOrderDTO.ProductoDTO;
import Interfaces.IInventarioBO;
import Interfaces.IInventarioDAO;
import goorderpersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class InventarioBO implements IInventarioBO {

    private static final Logger LOGGER = Logger.getLogger(InventarioBO.class.getName());    
    
    private IInventarioDAO inventarioDAO;
    
    public InventarioBO(IInventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }
     
    @Override
    public ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntity(producto);
            inventarioDAO.agregarProducto(p);
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Erro al agregar producto(s).");
        }
    }

    @Override
    public List<ProductoDTO> obtenerListaProductos() throws NegocioException {
        try {
            List<Producto> lista = inventarioDAO.obtenerListaProductos();
            List<ProductoDTO> listaDTO = new ArrayList<>();
            for (Producto p: lista) {
                listaDTO.add(DtoEntityProduct.toDTO(p));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar productos.");
        }         
    }

    @Override
    public List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException {
        try {
            List<Producto> lista = inventarioDAO.listarProductosFiltros(nombre, cantidad);
            List<ProductoDTO> listaDTO = new ArrayList<>();
            for (Producto p: lista) {
                listaDTO.add(DtoEntityProduct.toDTO(p));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Erro al filtrar productos.");
        }        
    }
}

package org.example;

import Adapters.DtoEntityProduct;
import Entidades.Producto;
import GeneradorIDS.IDProductoGenerador;
import GoOrderDTO.ProductoDTO;
import Interfaces.IInventarioBO;
import Interfaces.IPersistenciaFachada;
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
    
    private IPersistenciaFachada inventarioDAO;
    
    public InventarioBO(IPersistenciaFachada inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }
     
    @Override
    public ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            String idGenerada = IDProductoGenerador.generadorIdProducto();
            p.setId(idGenerada);
            producto.setId(idGenerada);
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

    @Override
    public ProductoDTO actualizarSumarProductoInventario(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            Producto productoActualizado = inventarioDAO.actualizarSumarProductoInventario(p);
            producto.setCantidad(productoActualizado.getCantidad());
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar cantidad de producto.");
        }
    }

    @Override
    public ProductoDTO actualizarRestarProductoInventario(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            Producto productoActualizado = inventarioDAO.actualizarRestarProductoInventario(p);
            producto.setCantidad(productoActualizado.getCantidad());
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar cantidad de producto.");
        }
    }
}
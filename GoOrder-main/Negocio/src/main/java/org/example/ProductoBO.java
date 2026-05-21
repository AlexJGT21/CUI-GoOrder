
package org.example;

import Adapters.DtoEntityProduct;
import Entidades.Producto;
import GeneradorIDS.IDProductoGenerador;
import GoOrderDTO.ProductoDTO;
import Interfaces.IPersistenciaFachada;
import Interfaces.IProductoBO;
import goorderpersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author maild
 */
public class ProductoBO implements IProductoBO {

    private static final Logger LOGGER = Logger.getLogger(ProductoBO.class.getName());
    private IPersistenciaFachada productoDAO;

    public ProductoBO(IPersistenciaFachada persistencia) {
        this.productoDAO = persistencia;
    }

    @Override
    public List<ProductoDTO> buscarProducto(String nombreProducto) throws NegocioException {
        try {
            List<Producto> listaEntity = productoDAO.obtenerProducto(nombreProducto);
            List<ProductoDTO> listaDTo = new ArrayList<>();
            
            for (Producto p: listaEntity) {
                listaDTo.add(DtoEntityProduct.toDTO(p));
            }
            return listaDTo;
        } catch (PersistenciaException e) {
            throw new NegocioException("No fue posible realizar busqueda.");
        }
    }

    @Override
    public List<ProductoDTO> listarProductos() throws NegocioException {
        try {
            List<Producto> lista = productoDAO.listarProductos();
            List<ProductoDTO> listaDTO = new ArrayList<>();

            for (Producto p: lista) {
                listaDTO.add(DtoEntityProduct.toDTO(p));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("No fue posible consultar productos.");
        }
    }

    //-----------------------------------------------------------------------------------------------

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            String idProducto = IDProductoGenerador.generadorIdProducto();
            //Asignamos ID al Entity
            p.setId(idProducto);
            //Asignamos ID al DTO
            producto.setId(idProducto);
            
            productoDAO.crearProducto(p);
            return producto;
        } catch (PersistenciaException e) {
            throw new NegocioException("Erro al guardar producto.");
        }
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            productoDAO.actualizarProducto(p);
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar producto.");            
        }
    }

    @Override
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntityMemory(producto);
            productoDAO.eliminarProducto(p);
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar producto.");   
        }
    }

    @Override
    public List<ProductoDTO> obtenerProducto(String nombreProducto) throws NegocioException {
        try {
            List<Producto> lista = productoDAO.obtenerProducto(nombreProducto);
            List<ProductoDTO> listaDTO = new ArrayList<>();

            for (Producto produ: lista) {
                listaDTO.add(DtoEntityProduct.toDTOMemory(produ));
            }
            return listaDTO;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible obtener producto(s).");
        }
    }    

    @Override
    public ProductoDTO obtenerProductoPorId(ProductoDTO producto) throws NegocioException {
        try {
            Producto p = DtoEntityProduct.toEntity(producto);
            productoDAO.obtenerProductoPorId(p);
            return producto;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible consultar el producto.");
        }
    }
}
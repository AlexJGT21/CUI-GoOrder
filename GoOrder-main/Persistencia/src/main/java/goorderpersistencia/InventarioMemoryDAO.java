
package goorderpersistencia;

import Entidades.Producto;
import Interfaces.IInventarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author maild
 */
public class InventarioMemoryDAO implements IInventarioDAO {

    private static final Logger LOGGER = Logger.getLogger(InventarioMemoryDAO.class.getName());       
    private List<Producto> inventario;       
    
    public InventarioMemoryDAO() {
        inventario = new ArrayList<>();
    }
        
    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        try {
            inventario.add(producto);
            return producto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al agregar producto.", e);
        }
    }
    
    @Override
    public List<Producto> obtenerListaProductos() throws PersistenciaException {
        try {
            return inventario;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al listar productos", e);
        }
    }

    @Override
    public List<Producto> listarProductosFiltros(String nombre, Integer cantidad) throws PersistenciaException {
        List<Producto> listaProductos = new ArrayList<>();
        try {
            //Algo de validar entradas
            boolean filtrarPorNombre = nombre != null && !nombre.trim().isEmpty();
            boolean filtrarPorCantidad = cantidad != null && cantidad > 0;           
            
            //Es correcto todo este if anidado?
            for (Producto p: inventario) { //Filtro para comparar tambien por el producto
                if (filtrarPorNombre && filtrarPorCantidad && p.getNombre().contains(nombre) && p.getCantidad()== cantidad) {
                    listaProductos.add(p);
                } else if (filtrarPorNombre && p.getNombre().contains(nombre)) {
                    listaProductos.add(p);
                } else if (filtrarPorCantidad && p.getCantidad() == cantidad) {
                    listaProductos.add(p);
                }
            }
            return listaProductos;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al filtrar productos.", e);
        }        
    }

    @Override
    public Producto actualizarSumarProductoInventario(Producto producto) throws PersistenciaException {
        try {
            Producto existeProducto = null;
            for (Producto p: inventario) {
                if (p.getId().equals(producto.getId())) {
                    existeProducto = p;
                    break;
                }
            }            
            if (existeProducto != null) {
                int nuevoStock = existeProducto.getCantidad() + producto.getCantidad();
                existeProducto.setCantidad(nuevoStock);
            }
            return existeProducto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al actualizar stock del producto.");
        }
    }

    @Override
    public Producto actualizarRestarProductoInventario(Producto producto) throws PersistenciaException {
       try {
            Producto existeProducto = null;
            for (Producto p: inventario) {
                if (p.getId().equals(producto.getId())) {
                    existeProducto = p;
                    break;
                }
            }            
            if (existeProducto != null) {
                int nuevoStock = existeProducto.getCantidad() - producto.getCantidad();
                existeProducto.setCantidad(nuevoStock);
            }
            return existeProducto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al actualizar stock del producto.");
        }
    }
}
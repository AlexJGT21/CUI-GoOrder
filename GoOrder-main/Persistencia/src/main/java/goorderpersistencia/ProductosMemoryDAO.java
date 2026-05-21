
package goorderpersistencia;

import Entidades.Producto;
import Interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ProductosMemoryDAO implements IProductoDAO {

    /**
     * Este es un producto concreto que implementa al producto con sus metodos "IProductoDAO"
     */    
    private static final Logger LOGGER = Logger.getLogger(ProductosMemoryDAO.class.getName());
    
    /**
     * Propia lista de productos
     */
    private List<Producto> productos;

    public ProductosMemoryDAO() {
        productos = new ArrayList<>();
        productos.add(new Producto("Latte", "Un tipo de cafe", 50.00, "latte_vainilla.png"));
        productos.add(new Producto("Paninni", "Queso y Jamon", 50.00, "panini_clasico.png"));
        productos.add(new Producto("Galleta de chispas", "Galleta con chispas de chocolate", 15.00, "galleta_chispas.png"));

        productos.add(new Producto("Espresso", "Cafe fuerte", 30.00, "espresso.png"));
        productos.add(new Producto("Capuccino", "Cafe espumado", 50.00, "capuccino.png"));
        productos.add(new Producto("Mocha", "Cafe chocolate", 55.00, "mocha.png"));
        productos.add(new Producto("Croissant", "Pan mantequilla", 35.00, "croissant.png"));

        productos.add(new Producto("Muffin", "Pan dulce", 28.00, "muffin.png"));
        productos.add(new Producto("Brownie", "Pastel chocolate", 32.00, "brownie.png"));
        productos.add(new Producto("Sandwich", "Pan con jamon", 48.00, "sandwich.png"));
        
        productos.add(new Producto("Bagel", "Pan con queso", 40.00, "bagel.png"));      
    }

    @Override
    public List<Producto> buscarProducto(String nombreProducto) throws PersistenciaException {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p: productos) {
            if (p.getNombre().toLowerCase().contains(nombreProducto.toLowerCase())) {
                resultado.add(p);
            }
        }
        if (resultado.isEmpty()) {
            throw new PersistenciaException("Producto(s) no encontrado(s)");
        }
        return resultado;  
    }

    @Override
    public List<Producto> listarProductos() throws PersistenciaException {
        return productos;
    }

    //----------------------------------------------------------------------------------------------------
    
    @Override
    public Producto crearProducto(Producto producto) throws PersistenciaException {
        try {
            productos.add(producto);
            return producto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error: " + e.getMessage(), e);
        }
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        try {
            for (Producto p: productos) {
                if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                    p.setCantidad(producto.getCantidad());
                }
            }     
            return producto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error: " + e.getMessage(), e);
        }
    }

    @Override
    public Producto eliminarProducto(Producto producto) throws PersistenciaException {
        try {
            for (Producto p: productos) {
                if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                    productos.remove(p);
                }
            }
            return producto;
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Producto> obtenerProducto(String nombreProducto) throws PersistenciaException {
        List<Producto> lista = new ArrayList<>();
        try {
            if (productos.isEmpty()) {
                throw new PersistenciaException("Error: Lista vacia.");
            } else { //else porque si xd
                for (Producto p: productos) {
                    if (p.getNombre().toLowerCase().contains(nombreProducto.toLowerCase())) {
                        lista.add(p);
                    }
                }
            }
            return lista;
        } catch (PersistenciaException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error: " + e.getMessage(), e);
        }
    }        

    @Override
    public Producto obtenerProductoPorId(Producto producto) throws PersistenciaException {
        if (productos == null || productos.isEmpty()) {
            return null;
        }
        Producto existe = null;
        for (Producto p: productos) {
            if (p.getId().equals(producto.getId())) {
                existe = p;
                break;
            }
        }
        return existe;
    }
}
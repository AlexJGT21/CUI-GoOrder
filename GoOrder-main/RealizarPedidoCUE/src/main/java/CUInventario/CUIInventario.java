
package CUInventario;

import CUInterfaces.ICUIInventario;
import GoOrderDTO.ProductoDTO;
import Interfaces.IInventarioBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.example.NegocioException;

/**
 *
 * @author maild
 */
public class CUIInventario implements ICUIInventario {

    private static final Logger LOGGER = Logger.getLogger(CUIInventario.class.getName());
    private IInventarioBO inventarioBO;
    
    public CUIInventario(IInventarioBO inventarioBO) {
        this.inventarioBO = inventarioBO;
    }/**
     * Metodo que valida los datos de un producto antes de agregarlo a la lista de inventario
     * @param producto Producto que se va a validar
     * @return Producto registrado de manera existosa
     * @throws NegocioException No fue posible realizar el registro debido a datos invalidos
     */
    @Override
    public ProductoDTO agregarProducto(ProductoDTO producto) throws NegocioException {
        try {
            //Validacio
            if (producto == null) {
                throw new NegocioException("Debe existir un producto para poder ser agregado al inventario.");
            }
            
            //Validacion de datos para comprobar estado
            if (producto.getNombre() != null && producto.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre del producto no puede ser nulo.");
            }
            if (producto.getNombre().matches("\\d+")) {
                throw new NegocioException("El nombre no puede contener números.");
            }
            
            //Valicacion descripcion
            if (producto.getDescripcion() == null) {
                throw new NegocioException("La descripción no puede ser nula.");
            }
            if (producto.getDescripcion().trim().isEmpty()) {
                throw new NegocioException("La descripción no puede quedar vacia.");
            }
            if (producto.getDescripcion().matches("\\d+")) {
                throw new NegocioException("La descripción no puede contener números.");
            }
            if (producto.getDescripcion().length() > 50) {
                throw new NegocioException("La descripción del producro excede los 50 caracteres permitidos.");
            }
            
            //Precio
            if (producto.getPrecio() == null) {
                throw new NegocioException("El precio no puede ser nulo.");
            }
            if (producto.getPrecio() <= 0 ) {
                throw new NegocioException("La cantidad no puede ser menor a 0.");
            }
            
            //Cantidad - Validar tambien el Spinner
            if (producto.getCantidadT() <= 0) {
                throw new NegocioException("La cantidad no puede ser menor o igual a 0.");                
            }
            
            //Imagen - arreglo de bytes
            if (producto.getImagenP() == null) {
                throw new NegocioException("La imagen no puede ser nula.");
            }            
            if (producto.getImagenP().length == 0) {
                throw new NegocioException("La imagen no puede quedar vacia.");
            }            
            return inventarioBO.agregarProducto(producto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Erro al agregar producto al inventario.");
        }
    }

    @Override
    public List<ProductoDTO> obtenerListaProductos() throws NegocioException {
        try {
            //Validaciones de lista
            List<ProductoDTO> lista = inventarioBO.obtenerListaProductos();            
            if (lista.isEmpty()) {
                return new ArrayList<>();
            }
            return lista;
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar inventario de productos.");
        }
    }

    @Override
    public List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException {
        try {
            return inventarioBO.listarProductosFiltros(nombre, cantidad);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al filtrar productos: " + e.getMessage());
        }
    }
    
    @Override
    public ProductoDTO actualizarSumarProductoInventario(ProductoDTO producto) throws NegocioException {
        try {
            if (producto.getCantidadT() <= 0) {
                throw new NegocioException("Para actualizar una cantidad no puede ser menor a 0.");
            }
            return inventarioBO.actualizarSumarProductoInventario(producto);
        } catch (NegocioException e) {
            throw new NegocioException("Error al sumar nueva cantidad de producto.");
        }
    }
     
    @Override
    public ProductoDTO actualizarRestarProductoInventario(ProductoDTO producto) throws NegocioException {
        try {
            if (producto.getCantidadT() <= 0) {
                throw new NegocioException("La cantidad no puede ser menor a 0.");
            }
            return inventarioBO.actualizarRestarProductoInventario(producto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al actualizar la salida de producto.");
        }
    }    
}
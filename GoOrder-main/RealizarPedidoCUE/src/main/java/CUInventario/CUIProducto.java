
package CUInventario;

import CUInterfaces.ICUIProducto;
import GoOrderDTO.ProductoDTO;
import Interfaces.IProductoBO;
import java.util.List;
import java.util.logging.Logger;
import org.example.NegocioException;

/**
 *
 * @author maild
 */
public class CUIProducto implements ICUIProducto {

    private static final Logger LOGGER = Logger.getLogger(CUIProducto.class.getName());    
    private IProductoBO productoBO;
    
    public CUIProducto(IProductoBO productoBO) {
        this.productoBO = productoBO;
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException {
        try {
            //Validacion nombre
            if (producto.getNombre() == null) {
                throw new NegocioException("El nombre no puede ser nulo.");
            }
            if (producto.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre no puede quedar vacio.");
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
            return productoBO.crearProducto(producto);
        } catch (NegocioException e) {
            throw new NegocioException("No fue posible agregar el producto.");
        }
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException {
        try {
            //Validacion por nombre
            if (producto.getNombre() != null && producto.getNombre().trim().isEmpty()) {
                throw new NegocioException("Para actualizar ingrese un nombre.");
            }
            if (producto.getNombre().matches("\\d+")) {
                throw new NegocioException("El nombre no puede contener números.");
            }
            
            //Validacion por cantidad
            if (producto.getCantidadT() <= 0) {
                throw new NegocioException("La cantidad del producto a actualizar debe ser mayor a 0.");
            }
            return productoBO.actualizarProducto(producto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible actualizar el producto.");
        }
    }

    @Override
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException {
        try {
            
            //Validacion por ID
            if (producto.getId() == null) {
                throw new NegocioException("Seleccione un producto para realizar salida de producto(s)");
            }
            
            //Validacion por nombre
            if (producto.getNombre() != null && producto.getNombre().trim().isEmpty()) {
                throw new NegocioException("Para eliminar un producto ingrese un nombre.");
            }
            if (producto.getNombre().matches("\\d+")) {
                throw new NegocioException("El nombre no puede contener números.");
            }
            
            //Validacion de cantidad
            if (producto.getCantidadT() <= 0) {
                throw new NegocioException("La cantidad no puede ser menor a 0.");
            }
            return productoBO.eliminarProducto(producto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible completar la eliminación del producto.");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProducto(String nombreProducto) throws NegocioException {
        try {
            if (nombreProducto != null && nombreProducto.trim().isEmpty()) {
                throw new NegocioException("El nombre del producto no puede quedar vacio.\nIngrese datos para comenzar busqueda de producto(s)");
            }
            if (nombreProducto.matches("\\d+")) {
                throw new NegocioException("El nombre del producto no puede contener números.");
            }
            return productoBO.obtenerProducto(nombreProducto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible obtener los productos solicitado(s).");
        }
    }   
    
    @Override
    public List<ProductoDTO> listarProductos() throws NegocioException {
        return productoBO.listarProductos();
    }
}
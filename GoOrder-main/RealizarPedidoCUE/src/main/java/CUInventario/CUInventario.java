
package CUInterfaces;

import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.SalidaProductoDTO;
import Interfaces.IEntradaProductoBO;
import Interfaces.IInventarioBO;
import Interfaces.IProductoBO;
import Interfaces.ISalidaProductoBO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.example.InventarioBO;
import org.example.NegocioException;

/**
 *
 * @author
 */
public class CUInventario implements ICUInventario {

    private static final Logger LOGGER = Logger.getLogger(CUInventario.class.getName());   
    
    private IProductoBO productoBO;
    private IInventarioBO inventarioBO;
    private IEntradaProductoBO entradaBO;
    private ISalidaProductoBO salidaBO;
    
    public CUInventario(IProductoBO productoBO, InventarioBO inventarioBO, IEntradaProductoBO entradaBO, ISalidaProductoBO salidaBO) {
        this.productoBO = productoBO;
        this.inventarioBO = inventarioBO;
        this.entradaBO = entradaBO;
        this.salidaBO = salidaBO;
    }
    
    //Producto

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
            if (producto.getCantidadT() < 0) {
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
    
    //Inventario

    /**
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
            if (inventarioBO.obtenerListaProductos().isEmpty()) {
                throw new NegocioException("No existen productos de momento por consultar.");
            }
            return inventarioBO.obtenerListaProductos();
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al listar inventario de productos.");
        }
    }

    @Override
    public List<ProductoDTO> listarProductosFiltros(String nombre, Integer cantidad) throws NegocioException {
        try {
            //Validaciones de nombre
            if (nombre != null && nombre.trim().isEmpty()) {
                throw new NegocioException("El nombre no puede quedar vacio. Ingrese un nombre para iniciar filtrado.");
            }
            if (nombre.matches("\\d+")) {
                throw new NegocioException("El nombre no puede contener valores númericos");
            }
            
            //Validaciones por cantidad
            if (cantidad <= 0) {
                throw new NegocioException("La cantidad no puede ser menor o igual a 0. Ingrese una cantidad para iniciar filtrado.");
            }
            return inventarioBO.listarProductosFiltros(nombre, cantidad);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("Error al filtrar productos");
        }
    }
    
    //Entrada producto

    @Override
    public EntradaProductoDTO nuevaEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException {
        try {
            if (entradaProducto == null) {
                throw new NegocioException("La entrada no puede ser nula. Ingrese datos para comenzar registro.");
            }
            
            //REVISAR LAS SIGUIENTES VALIDACIONES
            //¿CUALES PUEDO REALIZAR?
            if (entradaProducto.getProductosIDs().isEmpty()) {
                throw new NegocioException("");
            }
            if (entradaProducto.getCantidadTotalEntradas() < 0) {
                throw new NegocioException("");
            }
            if (entradaProducto.getRegistroEntrada().isEmpty()) {
                throw new NegocioException("");
            }
            
            return entradaBO.nuevaEntradaProducto(entradaProducto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar el registro de la nueva entrada.");
        }
    }

    @Override
    public EntradaProductoDTO actualizarEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException {
        try {
            if (entradaProducto.getId() == null) {
                throw new NegocioException("");
            }
            if (entradaProducto.getProductosIDs().isEmpty()) {
                throw new NegocioException("");
            }
            if (entradaProducto.getCantidadTotalEntradas() < 0) {
                throw new NegocioException("");
            }
            if (entradaProducto.getRegistroEntrada().isEmpty()) {
                throw new NegocioException("");
            }
            return entradaBO.actualizarEntradaProducto(entradaProducto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible completar la actualización de la entrada del producto seleccionado.");
        }
    }

    @Override
    public List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException {
        try {
            return entradaBO.listarEntradasProductos();
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible consultar la lista de entrada de productos.");
        }
    }

    @Override
    public List<EntradaProductoDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        try {
            if (fechaInicio == null) {
                throw new NegocioException("La fecha de inicio no puede quedar vacia.");
            }
            if (fechaFin == null) {
                throw new NegocioException("La fecha final no puede estar vacia.");
            }
            
            if (fechaInicio.isAfter(fechaFin)) {
                throw new NegocioException("Las fechas estan al reves. Corregir orden cronologico.");
            }
            return entradaBO.listarHistorialEntradas(fechaInicio, fechaFin);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar la busqueda con los filtros de fechas especificados.");
        }
    }
    
    //Salida producto

    @Override
    public SalidaProductoDTO nuevaSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException {
        try {
            if (salidaProducto == null) {
                throw new NegocioException("La entrada no puede ser nula. Ingrese datos para comenzar registro.");
            }
            
            //REVISAR LAS SIGUIENTES VALIDACIONES
            //¿CUALES PUEDO REALIZAR?
            if (salidaProducto.getProductosIDs().isEmpty()) {
                throw new NegocioException("");
            }
            if (salidaProducto.getCantidadTotalSalidas() < 0) {
                throw new NegocioException("");
            }
            if (salidaProducto.getRegistroSalida().isEmpty()) {
                throw new NegocioException("");
            }
            
            return salidaBO.nuevaSalidaProducto(salidaProducto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar el registro de la nueva entrada.");
        }
    }

    @Override
    public SalidaProductoDTO actualizarSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException {
        try {
            if (salidaProducto.getId() == null) {
                throw new NegocioException("");
            }
            if (salidaProducto.getProductosIDs().isEmpty()) {
                throw new NegocioException("");
            }
            if (salidaProducto.getCantidadTotalSalidas() < 0) {
                throw new NegocioException("");
            }
            if (salidaProducto.getRegistroSalida().isEmpty()) {
                throw new NegocioException("");
            }
            return salidaBO.actualizarSalidaProducto(salidaProducto);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible completar la actualización de la entrada del producto seleccionado.");
        }    
    }

    @Override
    public List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException {
        try {
            return salidaBO.listarSalidaProductos();
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible consultar la lista de salidas de productos.");
        }
    }

    @Override
    public List<SalidaProductoDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        try {
            if (fechaInicio == null) {
                throw new NegocioException("La fecha de inicio no puede quedar vacia.");
            }
            if (fechaFin == null) {
                throw new NegocioException("La fecha final no puede estar vacia.");
            }
            
            if (fechaInicio.isAfter(fechaFin)) {
                throw new NegocioException("Las fechas estan al reves. Corregir orden cronologico.");
            }
            return salidaBO.listarHistorialSalidas(fechaInicio, fechaFin);
        } catch (NegocioException e) {
            LOGGER.severe(e.getMessage());
            throw new NegocioException("No fue posible realizar la busqueda con los filtros de fechas especificados.");
        }    
    }       
}

package GoOrderDTO;

/**
 *
 * @author 
 */
public class ProductoDTO {
        
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidadT; //¿Por que le puse T?
    //IMAGENES
    private String imagen;
    private byte[] imagenP;
    
    private int cantidad = 1;
    
    public ProductoDTO() {
    }

    /**
     * Constructor con atributo imagen String
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidadT
     * @param imagen
     */
    public ProductoDTO(String id, String nombre, String descripcion, Double precio, Integer cantidadT, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadT = cantidadT;
        this.imagen = imagen;
    }

    /**
     * Constructor con atributo imagen byte[]
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidadT
     * @param imagenP 
     */
    public ProductoDTO(String id, String nombre, String descripcion, Double precio, Integer cantidadT, byte[] imagenP) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadT = cantidadT;
        this.imagenP = imagenP;
    }

    public ProductoDTO(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public ProductoDTO(String nombre, Double precio, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public ProductoDTO(String nombre, String descripcion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public ProductoDTO(String nombre, String descripcion, Double precio, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadT() {
        return cantidadT;
    }

    public void setCantidadT(Integer cantidadT) {
        this.cantidadT = cantidadT;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagenP() {
        return imagenP;
    }

    public void setImagenP(byte[] imagenP) {
        this.imagenP = imagenP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }        

    @Override
    public String toString() {
        return "ProductoDTO{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen + ", cantidad=" + cantidadT + '}';
    }        
}
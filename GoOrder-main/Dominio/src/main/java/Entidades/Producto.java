
package Entidades;


/**
 *
 * @author 
 */
public class Producto {
    
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
    //IMAGENES
    private String imagen;
    private byte[] imagenP;

    public Producto() {
    }

    /**
     * Constructor con atributo de imagen String
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidad
     * @param imagen 
     */
    public Producto(String id, String nombre, String descripcion, Double precio, Integer cantidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    /**
     * Constructor con atributo de imagen byte[]
     * @param id
     * @param nombre
     * @param descripcion
     * @param precio
     * @param cantidad
     * @param imagenP 
     */
    public Producto(String id, String nombre, String descripcion, Double precio, Integer cantidad, byte[] imagenP) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagenP = imagenP;
    }

    public Producto(String nombre, String descripcion, Double precio, String imagen) {
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", imagen=" + imagen + ", imagenP=" + imagenP + '}';
    }
}

package GoOrderDTO;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroEntradaDTO {
    
    private String id;
    private String idProducto;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;
    
    public RegistroEntradaDTO() {
    }

    public RegistroEntradaDTO(String id, String idProducto, String nombre, Double precio, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public LocalDateTime getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(LocalDateTime fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    @Override
    public String toString() {
        return "RegistroEntradaDTO{" + "id=" + id + ", idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }    
}
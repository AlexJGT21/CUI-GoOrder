
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroSalida {
    
    private String id;
    private String idProducto;
    private String nombre;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;
    
    public RegistroSalida() {        
    }

    public RegistroSalida(String id, String idProducto, String nombre, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idProducto = idProducto;
        this.nombre = nombre;
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
        return "RegistroSalida{" + "id=" + id + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }
}
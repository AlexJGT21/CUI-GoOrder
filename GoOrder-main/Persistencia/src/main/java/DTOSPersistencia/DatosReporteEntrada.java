
package DTOSPersistencia;

import java.time.LocalDateTime;

/**
 *
 * @author Tilin
 */
public class DatosReporteEntrada {
    
    private String idProducto;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private LocalDateTime fechaHoraOperacion;

    public DatosReporteEntrada() {        
    }

    public DatosReporteEntrada(String idProducto, String nombre, Integer cantidad, Double precio, LocalDateTime fechaHoraOperacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaHoraOperacion = fechaHoraOperacion;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(LocalDateTime fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    @Override
    public String toString() {
        return "DatosReporteDTO{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }    
}
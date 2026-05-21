
package GoOrderDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author
 */
public class DatosReporteSalidaDTO {
    
    private String id;
    private String nombre;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;

    public DatosReporteSalidaDTO() {
    }

    public DatosReporteSalidaDTO(String id, String nombre, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
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
    
    public String getFechaFormato() {
        if (fechaHoraOperacion == null) {
            return "";
        }
        return fechaHoraOperacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return "DatosReporteSalidaDTO{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }        
}
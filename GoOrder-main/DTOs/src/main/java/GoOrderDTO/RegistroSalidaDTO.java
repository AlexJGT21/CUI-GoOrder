
package GoOrderDTO;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroSalidaDTO {
    
    private String id;
    private String idSalidaProducto;
    private String idProducto;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;
    
    public RegistroSalidaDTO() {        
    }

    public RegistroSalidaDTO(String id, String idSalidaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idSalidaProducto = idSalidaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public String getId() {
        return id;
    }

    public String getIdSalidaProducto() {
        return idSalidaProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdSalidaProducto(String idSalidaProducto) {
        this.idSalidaProducto = idSalidaProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaHoraOperacion(LocalDateTime fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }
}
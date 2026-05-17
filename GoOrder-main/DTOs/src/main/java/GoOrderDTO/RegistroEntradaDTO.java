
package GoOrderDTO;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroEntradaDTO {
    
    private String id;
    private String idEntradaProducto;
    private String idProducto;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;
    
    public RegistroEntradaDTO() {
    }

    public RegistroEntradaDTO(String id, String idEntradaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idEntradaProducto = idEntradaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public String getId() {
        return id;
    }

    public String getIdEntradaProducto() {
        return idEntradaProducto;
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

    public void setIdEntradaProducto(String idEntradaProducto) {
        this.idEntradaProducto = idEntradaProducto;
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
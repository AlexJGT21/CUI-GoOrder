
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroSalida {
    
    private String id;
    private String idSalidaProducto;
    private String idProducto;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;
    
    public RegistroSalida() {        
    }

    public RegistroSalida(String id, String idSalidaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idSalidaProducto = idSalidaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public RegistroSalida(String idSalidaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.idSalidaProducto = idSalidaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSalidaProducto() {
        return idSalidaProducto;
    }

    public void setIdSalidaProducto(String idSalidaProducto) {
        this.idSalidaProducto = idSalidaProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
        return "RegistroSalida{" + "id=" + id + ", idSalidaProducto=" + idSalidaProducto + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }    
}
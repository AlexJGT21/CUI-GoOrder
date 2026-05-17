
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class RegistroEntrada {
    
    /**
     * Esta clase representa el documento anidado
     */
    
    private String id;
    private String idEntradaProducto;
    private String idProducto;
    private Integer cantidad;
    private LocalDateTime fechaHoraOperacion;

    public RegistroEntrada() {
    }

    public RegistroEntrada(String id, String idEntradaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.id = id;
        this.idEntradaProducto = idEntradaProducto;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public RegistroEntrada(String idEntradaProducto, String idProducto, Integer cantidad, LocalDateTime fechaHoraOperacion) {
        this.idEntradaProducto = idEntradaProducto;
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

    public String getIdEntradaProducto() {
        return idEntradaProducto;
    }

    public void setIdEntradaProducto(String idEntradaProducto) {
        this.idEntradaProducto = idEntradaProducto;
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
        return "RegistroEntrada{" + "id=" + id + ", idEntradaProducto=" + idEntradaProducto + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", fechaHoraOperacion=" + fechaHoraOperacion + '}';
    }        
}
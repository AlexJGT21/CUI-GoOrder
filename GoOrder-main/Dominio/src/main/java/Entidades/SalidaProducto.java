
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class SalidaProducto {
    
    private String id;
    private Integer cantidadTotalSalidas;
    private List<RegistroSalida> registroSalida;

    public SalidaProducto() {
        this.cantidadTotalSalidas = 0;
        this.registroSalida = new ArrayList<>();
    }

    public SalidaProducto(String id, Integer cantidadTotalSalidas, List<RegistroSalida> registroSalida) {
        this.id = id;
        this.cantidadTotalSalidas = cantidadTotalSalidas;
        this.registroSalida = registroSalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidadTotalSalidas() {
        return cantidadTotalSalidas;
    }

    public void setCantidadTotalSalidas(Integer cantidadTotalSalidas) {
        this.cantidadTotalSalidas = cantidadTotalSalidas;
    }

    public List<RegistroSalida> getRegistroSalida() {
        return registroSalida;
    }

    public void setRegistroSalida(List<RegistroSalida> registroSalida) {
        this.registroSalida = registroSalida;
    }

    @Override
    public String toString() {
        return "SalidaProducto{" + "id=" + id + ", cantidadTotalSalidas=" + cantidadTotalSalidas + ", registroSalida=" + registroSalida + '}';
    }        
}
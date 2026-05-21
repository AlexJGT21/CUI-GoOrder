
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class EntradaProducto {
    
    private String id;
    private Integer cantidadTotalEntradas;
    private List<RegistroEntrada> registroEntrada;

    public EntradaProducto() {
        this.cantidadTotalEntradas = 0;
        this.registroEntrada = new ArrayList<>();
    }

    public EntradaProducto(String id, Integer cantidadTotalEntradas, List<RegistroEntrada> registroEntrada) {
        this.id = id;
        this.cantidadTotalEntradas = cantidadTotalEntradas;
        this.registroEntrada = registroEntrada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidadTotalEntradas() {
        return cantidadTotalEntradas;
    }

    public void setCantidadTotalEntradas(Integer cantidadTotalEntradas) {
        this.cantidadTotalEntradas = cantidadTotalEntradas;
    }

    public List<RegistroEntrada> getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(List<RegistroEntrada> registroEntrada) {
        this.registroEntrada = registroEntrada;
    }

    @Override
    public String toString() {
        return "EntradaProducto{" + "id=" + id + ", cantidadTotalEntradas=" + cantidadTotalEntradas + ", registroEntrada=" + registroEntrada + '}';
    }        
}
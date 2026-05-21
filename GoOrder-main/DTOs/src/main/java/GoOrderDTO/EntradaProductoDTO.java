
package GoOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class EntradaProductoDTO {
    
    private String id;
    private Integer cantidadTotalEntradas;
    private List<RegistroEntradaDTO> registroEntrada;
    
    public EntradaProductoDTO() {
        cantidadTotalEntradas = 0;
        registroEntrada = new ArrayList<>();
    }

    public EntradaProductoDTO(String id, Integer cantidadTotalEntradas, List<RegistroEntradaDTO> registroEntrada) {
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

    public List<RegistroEntradaDTO> getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(List<RegistroEntradaDTO> registroEntrada) {
        this.registroEntrada = registroEntrada;
    }

    @Override
    public String toString() {
        return "EntradaProductoDTO{" + "id=" + id + ", cantidadTotalEntradas=" + cantidadTotalEntradas + ", registroEntrada=" + registroEntrada + '}';
    }
}
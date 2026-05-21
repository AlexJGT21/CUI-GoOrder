
package GoOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class SalidaProductoDTO {
    
    private String id;
    private Integer cantidadTotalSalidas;
    private List<RegistroSalidaDTO> registroSalida;

    public SalidaProductoDTO() {
        this.cantidadTotalSalidas = 0;
        this.registroSalida = new ArrayList<>();
    }    

    public SalidaProductoDTO(String id, Integer cantidadTotalSalidas, List<RegistroSalidaDTO> registroSalida) {
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

    public List<RegistroSalidaDTO> getRegistroSalida() {
        return registroSalida;
    }

    public void setRegistroSalida(List<RegistroSalidaDTO> registroSalida) {
        this.registroSalida = registroSalida;
    }

    @Override
    public String toString() {
        return "SalidaProductoDTO{" + "id=" + id + ", cantidadTotalSalidas=" + cantidadTotalSalidas + ", registroSalida=" + registroSalida + '}';
    }
}
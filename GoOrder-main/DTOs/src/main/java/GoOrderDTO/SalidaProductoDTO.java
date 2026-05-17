
package GoOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class SalidaProductoDTO {
    
    private String id;
    private List<ProductoDTO> productosIDs;
    private Integer cantidadTotalSalidas;
    private List<RegistroSalidaDTO> registroSalida;

    public SalidaProductoDTO() {
        productosIDs = new ArrayList<>();
        cantidadTotalSalidas = 0;
        registroSalida = new ArrayList<>();
    }

    public SalidaProductoDTO(String id, List<ProductoDTO> productosIDs, Integer cantidadTotalSalidas, List<RegistroSalidaDTO> registroSalida) {
        this.id = id;
        this.productosIDs = productosIDs;
        this.cantidadTotalSalidas = cantidadTotalSalidas;
        this.registroSalida = registroSalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductoDTO> getProductosIDs() {
        return productosIDs;
    }

    public void setProductosIDs(List<ProductoDTO> productosIDs) {
        this.productosIDs = productosIDs;
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
    
    
    
}


package GoOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class EntradaProductoDTO {
    
    private String id;
    private List<ProductoDTO> productosIDs;
    private Integer cantidadTotalEntradas;
    private List<RegistroEntradaDTO> registroEntrada;
    
    public EntradaProductoDTO() {
        productosIDs = new ArrayList<>();
        cantidadTotalEntradas = 0;
        registroEntrada = new ArrayList<>();
    }

    public EntradaProductoDTO(String id, List<ProductoDTO> productosIDs, Integer cantidadTotalEntradas, List<RegistroEntradaDTO> registroEntrada) {
        this.id = id;
        this.productosIDs = productosIDs;
        this.cantidadTotalEntradas = cantidadTotalEntradas;
        this.registroEntrada = registroEntrada;
    }

    public String getId() {
        return id;
    }

    public List<ProductoDTO> getProductosIDs() {
        return productosIDs;
    }

    public Integer getCantidadTotalEntradas() {
        return cantidadTotalEntradas;
    }

    public List<RegistroEntradaDTO> getRegistroEntrada() {
        return registroEntrada;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductosIDs(List<ProductoDTO> productosIDs) {
        this.productosIDs = productosIDs;
    }

    public void setCantidadTotalEntradas(Integer cantidadTotalEntradas) {
        this.cantidadTotalEntradas = cantidadTotalEntradas;
    }

    public void setRegistroEntrada(List<RegistroEntradaDTO> registroEntrada) {
        this.registroEntrada = registroEntrada;
    }        
}
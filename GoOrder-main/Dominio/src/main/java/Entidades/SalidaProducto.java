
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class SalidaProducto {
    
    private String id;
    private List<Producto> productosIDs;
    private Integer cantidadTotalSalidas;
    private List<RegistroSalida> registroSalida;

    public SalidaProducto() {
        this.productosIDs = new ArrayList<>();
        this.cantidadTotalSalidas = 0;
        this.registroSalida = new ArrayList<>();
    }

    public SalidaProducto(String id, List<Producto> productosIDs, Integer cantidadTotalSalidas, List<RegistroSalida> registroSalida) {
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

    public List<Producto> getProductosIDs() {
        return productosIDs;
    }

    public void setProductosIDs(List<Producto> productosIDs) {
        this.productosIDs = productosIDs;
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
        return "SalidaProducto{" + "id=" + id + ", productosIDs=" + productosIDs + ", cantidadTotalSalidas=" + cantidadTotalSalidas + ", registroSalida=" + registroSalida + '}';
    }                    
}
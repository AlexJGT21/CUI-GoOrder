
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class EntradaProducto {
    
    private String id;
    private List<Producto> productosIDs;
    private Integer cantidadTotalEntradas;
    private List<RegistroEntrada> registroEntrada;

    public EntradaProducto() {
        this.productosIDs = new ArrayList<>();
        this.cantidadTotalEntradas = 0;
        this.registroEntrada = new ArrayList<>();
    }

    public EntradaProducto(String id, List<Producto> productosIDs, Integer cantidadTotalProductos, List<RegistroEntrada> registroEntrada) {
        this.id = id;
        this.productosIDs = productosIDs;
        this.cantidadTotalEntradas = cantidadTotalProductos;
        this.registroEntrada = registroEntrada;
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

    public Integer getCantidadTotalProductos() {
        return cantidadTotalEntradas;
    }

    public void setCantidadTotalProductos(Integer cantidadTotalProductos) {
        this.cantidadTotalEntradas = cantidadTotalProductos;
    }

    public List<RegistroEntrada> getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(List<RegistroEntrada> registroEntrada) {
        this.registroEntrada = registroEntrada;
    }

    @Override
    public String toString() {
        return "EntradaProducto{" + "id=" + id + ", productosIDs=" + productosIDs + ", cantidadTotalProductos=" + cantidadTotalEntradas + ", registroEntrada=" + registroEntrada + '}';
    }           
}
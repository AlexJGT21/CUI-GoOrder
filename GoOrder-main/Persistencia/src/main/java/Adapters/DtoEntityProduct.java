
package Adapters;

import Entidades.Producto;
import GoOrderDTO.ProductoDTO;

/**
 *
 * @author
 */
public class DtoEntityProduct {
    
    /**
     * Adapter que recibe una DTO de producto y regresa una Entity Producto
     * @param producto Parametro de conversion
     * @return Una Entity
     */
    public static Producto toEntity(ProductoDTO producto){
        if (producto == null) {
            return null;
        }
        return new Producto(producto.getNombre(),
                            producto.getDescripcion(),
                            producto.getPrecio(),
                            producto.getImagen());
    }
    
    /**
     * Adapter que recibe un Producto Entity y regresa una DTO Producto
     * @param producto Parametro de conversion
     * @return Una DTO
     */
    public static ProductoDTO toDTO(Producto producto){
        if (producto == null) {
            return null;
        }
        return new ProductoDTO(producto.getId(),
                               producto.getNombre(), 
                               producto.getDescripcion(),
                               producto.getPrecio(),
                               producto.getCantidad(),
                               producto.getImagenP());
    }
    
    /**
     * Adapter que recibe una Producto DTO y regresa una Producto EntityParaMemoria
     * @param producto DTO
     * @return EntityMemory
     */
    public static Producto toEntityMemory(ProductoDTO producto) {
        if (producto == null) {
            return null;
        }
        return new Producto(producto.getId(),
                            producto.getNombre(), 
                            producto.getDescripcion(),
                            producto.getPrecio(),
                            producto.getCantidadT(),
                            producto.getImagenP());
    }
    
    public static ProductoDTO toDTOMemory(Producto producto) {
        if (producto == null) {
            return null;
        }
        return new ProductoDTO(producto.getId(), 
                               producto.getNombre(), 
                               producto.getDescripcion(), 
                               producto.getPrecio(),
                               producto.getCantidad(),
                               producto.getImagenP());
    }
}
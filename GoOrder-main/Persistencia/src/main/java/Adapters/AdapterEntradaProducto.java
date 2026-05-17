
package Adapters;

import Entidades.EntradaProducto;
import Entidades.Producto;
import Entidades.RegistroEntrada;
import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.RegistroEntradaDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class AdapterEntradaProducto {
    
    public static EntradaProducto toEntity(EntradaProductoDTO entradaProducto) {
        return new EntradaProducto(entradaProducto.getId(),
                                   entityProductosIDs(entradaProducto.getProductosIDs()),
                                   entradaProducto.getCantidadTotalEntradas(),
                                   entityRegistroEntrada(entradaProducto.getRegistroEntrada()));
    }
    
    public static EntradaProductoDTO toDto(EntradaProducto entradaProducto) {
        return new EntradaProductoDTO(entradaProducto.getId(),
                                      dtoProductosIDs(entradaProducto.getProductosIDs()),
                                      entradaProducto.getCantidadTotalProductos(),
                                      dtoRegistroEntrada(entradaProducto.getRegistroEntrada()));
    }
    
    private static List<Producto> entityProductosIDs(List<ProductoDTO> producto) {
        List<Producto> listaEntitys = new ArrayList<>();
        if (producto != null) {
            for (ProductoDTO pDTO: producto) {
                Producto produ = new Producto();
                produ.setId(pDTO.getId());
                produ.setNombre(pDTO.getNombre());
                produ.setDescripcion(pDTO.getDescripcion());
                produ.setPrecio(pDTO.getPrecio());
                produ.setCantidad(pDTO.getCantidad());
                produ.setImagenP(pDTO.getImagenP());
                listaEntitys.add(produ);
            }
        }
        return listaEntitys;
    }
    
    private static List<RegistroEntrada> entityRegistroEntrada(List<RegistroEntradaDTO> registroEntrada) {
        List<RegistroEntrada> listaEntitys = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroEntradaDTO registroDTO: registroEntrada) {
                RegistroEntrada registro = new RegistroEntrada();
                registro.setId(registroDTO.getId());
                registro.setIdEntradaProducto(registroDTO.getIdEntradaProducto());
                registro.setIdProducto(registroDTO.getIdProducto());
                registro.setCantidad(registroDTO.getCantidad());
                registro.setFechaHoraOperacion(registroDTO.getFechaHoraOperacion());
                listaEntitys.add(registro);
            }
        }
        return listaEntitys;
    }
    
    //-----------------------------------------------------------------------------------------------------------
    
    private static List<ProductoDTO> dtoProductosIDs(List<Producto> producto) {
        List<ProductoDTO> listaDtos = new ArrayList<>();
        if (producto != null) {
            for (Producto p: producto) {
                ProductoDTO produ = new ProductoDTO();
                produ.setId(p.getId());
                produ.setNombre(p.getNombre());
                produ.setDescripcion(p.getDescripcion());
                produ.setPrecio(p.getPrecio());
                produ.setCantidad(p.getCantidad());
                produ.setImagenP(p.getImagenP());
                listaDtos.add(produ);
            }
        }
        return listaDtos;
    }
    
    private static List<RegistroEntradaDTO> dtoRegistroEntrada(List<RegistroEntrada> registroEntrada) {
        List<RegistroEntradaDTO> listaDtos = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroEntrada registroE: registroEntrada) {
                RegistroEntradaDTO registro = new RegistroEntradaDTO();
                registro.setId(registroE.getId());
                registro.setIdEntradaProducto(registroE.getIdEntradaProducto());
                registro.setIdProducto(registroE.getIdProducto());
                registro.setCantidad(registroE.getCantidad());
                registro.setFechaHoraOperacion(registroE.getFechaHoraOperacion());
                listaDtos.add(registro);
            }
        }
        return listaDtos;
    }
}

package Adapters;

import Entidades.Producto;
import Entidades.RegistroSalida;
import Entidades.SalidaProducto;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.RegistroSalidaDTO;
import GoOrderDTO.SalidaProductoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class AdapterSalidaProducto {
    
    public static SalidaProducto toEntity(SalidaProductoDTO salidaProducto) {
        return new SalidaProducto(salidaProducto.getId(), 
                                  entityProductosIDs(salidaProducto.getProductosIDs()),
                                  salidaProducto.getCantidadTotalSalidas(),
                                  entityRegistroSalida(salidaProducto.getRegistroSalida()));
    }
    
    public static SalidaProductoDTO toDto(SalidaProducto salidaProducto) {
        return new SalidaProductoDTO(salidaProducto.getId(),
                                     dtoProductosIDs(salidaProducto.getProductosIDs()),
                                     salidaProducto.getCantidadTotalSalidas(),
                                     dtoRegistroSalida(salidaProducto.getRegistroSalida()));
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
    
    private static List<RegistroSalida> entityRegistroSalida(List<RegistroSalidaDTO> registroEntrada) {
        List<RegistroSalida> listaEntitys = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroSalidaDTO registroDTO: registroEntrada) {
                RegistroSalida registro = new RegistroSalida();
                registro.setId(registroDTO.getId());
                registro.setIdSalidaProducto(registroDTO.getIdSalidaProducto());
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
    
    private static List<RegistroSalidaDTO> dtoRegistroSalida(List<RegistroSalida> registroSalida) {
        List<RegistroSalidaDTO> listaDtos = new ArrayList<>();
        if (registroSalida != null) {
            for (RegistroSalida registroS: registroSalida) {
                RegistroSalidaDTO registro = new RegistroSalidaDTO();
                registro.setId(registroS.getId());
                registro.setIdSalidaProducto(registroS.getIdSalidaProducto());
                registro.setIdProducto(registroS.getIdProducto());
                registro.setCantidad(registroS.getCantidad());
                registro.setFechaHoraOperacion(registroS.getFechaHoraOperacion());
                listaDtos.add(registro);
            }
        }
        return listaDtos;
    }
}
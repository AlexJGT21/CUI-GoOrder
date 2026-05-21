
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
                                  salidaProducto.getCantidadTotalSalidas(),
                                  entityRegistroSalida(salidaProducto.getRegistroSalida()));
    }
    
    public static SalidaProductoDTO toDto(SalidaProducto salidaProducto) {
        return new SalidaProductoDTO(salidaProducto.getId(),
                                     salidaProducto.getCantidadTotalSalidas(),
                                     dtoRegistroSalida(salidaProducto.getRegistroSalida()));
    }
    
    //-----------------------------------------------------------------------------------------------------

    private static List<RegistroSalida> entityRegistroSalida(List<RegistroSalidaDTO> registroEntrada) {
        List<RegistroSalida> listaEntitys = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroSalidaDTO registroDTO: registroEntrada) {
                RegistroSalida registro = new RegistroSalida();
                registro.setId(registroDTO.getId());
                registro.setIdProducto(registroDTO.getIdProducto());
                registro.setNombre(registroDTO.getNombre());
                registro.setCantidad(registroDTO.getCantidad());
                registro.setFechaHoraOperacion(registroDTO.getFechaHoraOperacion());
                listaEntitys.add(registro);
            }
        }
        return listaEntitys;
    }
    
    private static List<RegistroSalidaDTO> dtoRegistroSalida(List<RegistroSalida> registroSalida) {
        List<RegistroSalidaDTO> listaDtos = new ArrayList<>();
        if (registroSalida != null) {
            for (RegistroSalida registroS: registroSalida) {
                RegistroSalidaDTO registro = new RegistroSalidaDTO();
                registro.setId(registroS.getId());
                registro.setIdProducto(registroS.getIdProducto());
                registro.setNombre(registroS.getNombre());
                registro.setCantidad(registroS.getCantidad());
                registro.setFechaHoraOperacion(registroS.getFechaHoraOperacion());
                listaDtos.add(registro);
            }
        }
        return listaDtos;
    }
}
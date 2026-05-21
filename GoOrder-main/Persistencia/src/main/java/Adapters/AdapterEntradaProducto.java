
package Adapters;

import Entidades.EntradaProducto;
import Entidades.RegistroEntrada;
import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.RegistroEntradaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class AdapterEntradaProducto {
    
    public static EntradaProducto toEntity(EntradaProductoDTO entradaProducto) {
        return new EntradaProducto(
                entradaProducto.getId(),
                entradaProducto.getCantidadTotalEntradas(), 
                entityRegistroEntrada(entradaProducto.getRegistroEntrada()));
    }
    
    public static EntradaProductoDTO toDto(EntradaProducto entradaProducto) {
        return new EntradaProductoDTO(
                entradaProducto.getId(), 
                entradaProducto.getCantidadTotalEntradas(),
                dtoRegistroEntrada(entradaProducto.getRegistroEntrada()));
    }

    //-------------------------------------------------------------------------------------------------------------
    
    private static List<RegistroEntrada> entityRegistroEntrada(List<RegistroEntradaDTO> registroEntrada) {
        List<RegistroEntrada> listaEntitys = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroEntradaDTO registroDTO: registroEntrada) {
                RegistroEntrada registro = new RegistroEntrada();
                registro.setId(registroDTO.getIdProducto());
                registro.setNombre(registroDTO.getNombre());
                registro.setPrecio(registroDTO.getPrecio());
                registro.setCantidad(registroDTO.getCantidad());
                registro.setFechaHoraOperacion(registroDTO.getFechaHoraOperacion());
                listaEntitys.add(registro);
            }
        }
        return listaEntitys;
    }   
    
    private static List<RegistroEntradaDTO> dtoRegistroEntrada(List<RegistroEntrada> registroEntrada) {
        List<RegistroEntradaDTO> listaDtos = new ArrayList<>();
        if (registroEntrada != null) {
            for (RegistroEntrada registroE: registroEntrada) {
                RegistroEntradaDTO registro = new RegistroEntradaDTO();
                registro.setIdProducto(registroE.getId());
                registro.setNombre(registroE.getNombre());
                registro.setPrecio(registroE.getPrecio());
                registro.setCantidad(registroE.getCantidad());
                registro.setFechaHoraOperacion(registroE.getFechaHoraOperacion());
                listaDtos.add(registro);
            }
        }
        return listaDtos;
    }
}
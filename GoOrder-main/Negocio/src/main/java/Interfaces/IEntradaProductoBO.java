
package Interfaces;

import GoOrderDTO.DatosReporteEntradaDTO;
import GoOrderDTO.EntradaProductoDTO;
import java.time.LocalDate;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface IEntradaProductoBO {
    
    public abstract EntradaProductoDTO nuevaEntradaProducto(EntradaProductoDTO entradaProducto) throws NegocioException;
    public abstract List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException;
    public abstract List<DatosReporteEntradaDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;    
}


package CUInterfaces;

import GoOrderDTO.DatosReporteEntradaDTO;
import GoOrderDTO.EntradaProductoDTO;
import GoOrderDTO.ProductoDTO;
import java.time.LocalDate;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface ICUIEntradaProducto {
    
    //EntradaProducto
    public abstract EntradaProductoDTO nuevaEntradaProducto(List<ProductoDTO> listaProductosEntrantes) throws NegocioException;
    public abstract List<EntradaProductoDTO> listarEntradasProductos() throws NegocioException;
    public abstract List<DatosReporteEntradaDTO> listarHistorialEntradas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;
}

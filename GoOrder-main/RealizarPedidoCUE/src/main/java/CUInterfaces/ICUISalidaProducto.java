
package CUInterfaces;

import GoOrderDTO.DatosReporteSalidaDTO;
import GoOrderDTO.ProductoDTO;
import GoOrderDTO.SalidaProductoDTO;
import java.time.LocalDate;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface ICUISalidaProducto {
    
    //SalidaProducto
    public abstract SalidaProductoDTO nuevaSalidaProducto(List<ProductoDTO> listaProductosSalientes) throws NegocioException;
    public abstract List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException;
    public abstract List<DatosReporteSalidaDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;    
    
}


package Interfaces;

import GoOrderDTO.SalidaProductoDTO;
import java.time.LocalDate;
import java.util.List;
import org.example.NegocioException;

/**
 *
 * @author
 */
public interface ISalidaProductoBO {
         
    public abstract SalidaProductoDTO nuevaSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException;
    public abstract SalidaProductoDTO actualizarSalidaProducto(SalidaProductoDTO salidaProducto) throws NegocioException;
    public abstract List<SalidaProductoDTO> listarSalidaProductos() throws NegocioException;
    public abstract List<SalidaProductoDTO> listarHistorialSalidas(LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;    
}
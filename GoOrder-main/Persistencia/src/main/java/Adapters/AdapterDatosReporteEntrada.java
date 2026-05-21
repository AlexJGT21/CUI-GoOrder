
package Adapters;

import DTOSPersistencia.DatosReporteEntrada;
import GoOrderDTO.DatosReporteEntradaDTO;

/**
 *
 * @author
 */
public class AdapterDatosReporteEntrada {
    
    public static DatosReporteEntrada toPersistence(DatosReporteEntradaDTO datosReporte) {
        return new DatosReporteEntrada(
                datosReporte.getIdProducto(),
                datosReporte.getNombre(),
                datosReporte.getCantidad(),
                datosReporte.getPrecio(),
                datosReporte.getFechaHoraOperacion());
    }
    
    public static DatosReporteEntradaDTO toDTO(DatosReporteEntrada datosReporte) {
        return new DatosReporteEntradaDTO(
                datosReporte.getIdProducto(), 
                datosReporte.getNombre(), 
                datosReporte.getCantidad(), 
                datosReporte.getPrecio(), 
                datosReporte.getFechaHoraOperacion());
    }    
}
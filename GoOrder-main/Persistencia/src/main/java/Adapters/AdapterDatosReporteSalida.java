
package Adapters;

import DTOSPersistencia.DatosReporteSalida;
import GoOrderDTO.DatosReporteSalidaDTO;

/**
 *
 * @author
 */
public class AdapterDatosReporteSalida {
    
    public static DatosReporteSalida toPersistence(DatosReporteSalida datosReporte) {
        return new DatosReporteSalida(
                datosReporte.getIdProducto(), 
                datosReporte.getNombre(),
                datosReporte.getCantidad(),
                datosReporte.getFechaHoraOperacion());

    }
    
    public static DatosReporteSalidaDTO toDTO(DatosReporteSalida datosReporte) {
        return new DatosReporteSalidaDTO(
                datosReporte.getIdProducto(), 
                datosReporte.getNombre(), 
                datosReporte.getCantidad(), 
                datosReporte.getFechaHoraOperacion());
    }
}

package goorderpersistencia;

import DTOSPersistencia.DatosReporteEntrada;
import Entidades.EntradaProducto;
import Entidades.RegistroEntrada;
import Interfaces.IEntradaProductoDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author maild
 */
public class EntradaProductoMongoDAOTest {
    
    private static IEntradaProductoDAO dao;
    
    @BeforeAll
    public static void initComponent() {
        dao = new EntradaProductoMongoDAO();
    }
    
    @Test
    public void testNuevoRegistroDeEntrada() {        
        List<RegistroEntrada> registro = new ArrayList<>();
        registro.add(new RegistroEntrada(null, "PRODU:567", "Galletas", 40.00, 50, LocalDateTime.now()));
        EntradaProducto entrada = new EntradaProducto(null, 50, registro);
        
        assertDoesNotThrow(() -> {
            dao.nuevaEntradaProducto(entrada);
        });
    }
    
    @Test
    public void testFiltroDeFechasMongo() {
        LocalDate inicio = LocalDate.of(2026, Month.MAY, 01);
        LocalDate fin = LocalDate.of(2026, Month.MAY, 31);
        assertDoesNotThrow(() -> {
            List<DatosReporteEntrada> resultados = dao.listarHistorialEntradas(inicio, fin);
            for (DatosReporteEntrada datos: resultados) {
                System.out.println(datos.toString());
            }
        });        
    }       
}

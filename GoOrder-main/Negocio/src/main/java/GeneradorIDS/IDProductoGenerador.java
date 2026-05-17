
package GeneradorIDS;

/**
 *
 * @author
 */
public class IDProductoGenerador {
        
    /**
     * Rezo a lo que este despierto a esta hora
     * porque esta vaina loca jale
     * @return IDProducto generado automaticamente
     */
    public static String generadorIdProducto() {
        int min = 1000;
        int max = 9999;
        int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
        return "PROD:" + numeroAleatorio;
    }        
}
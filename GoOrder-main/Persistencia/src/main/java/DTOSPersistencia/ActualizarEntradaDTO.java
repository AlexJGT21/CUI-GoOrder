
package DTOSPersistencia;

/**
 *
 * @author
 */
public class ActualizarEntradaDTO {

    private String id;
    private String nombre;
    private Integer cantidad;

    public ActualizarEntradaDTO(String id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }      
}
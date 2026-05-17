
package ExploradorDeArchivos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author
 */
public class SelectorDeImagen {
    
    private JFileChooser fileChooser;
    private FileNameExtensionFilter filtro;
    private File selectFile;
    
    public SelectorDeImagen(){
        fileChooser = new JFileChooser();
        filtro = new FileNameExtensionFilter("Imagenes", "jpg", "jpeg", "png", "gif");
    }
    
    public void seleccionarImagen() {
        fileChooser.setDialogTitle("Seleccionar imagen.");
        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
        }
        
        
    }
    
}

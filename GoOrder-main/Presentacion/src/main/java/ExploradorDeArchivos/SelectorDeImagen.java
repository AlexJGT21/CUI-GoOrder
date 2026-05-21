
package ExploradorDeArchivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
        }
    }
    
    public byte[] obtenerBytesImagen() {
        if (selectFile == null) {
            return null;
        }
        try {
            return Files.readAllBytes(selectFile.toPath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar procesar imagen.");
            return null;
        }
    }    
}
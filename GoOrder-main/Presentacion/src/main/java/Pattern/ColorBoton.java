
package Pattern;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author 
 */
public class ColorBoton {
    
    private final Color colorOriginal = new Color(35, 35, 35);
    private final Color colorIluminado = new Color(51, 136, 20);
    private final JButton btnGlobal;
    
    public ColorBoton(JButton btn) {        
        this.btnGlobal = btn;
    }
    
    public void mouseEntered(MouseEvent eve){
        btnGlobal.setBackground(colorIluminado);
    }
    
    public void mouseExited(MouseEvent eve){
        btnGlobal.setBackground(colorOriginal);
    }
    
}

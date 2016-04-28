/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sansdecorateur;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Yvan
 */
public class JLabelClignotant extends JLabel {

    public JLabelClignotant(String string) {
        this(string, JLabel.LEFT);
    }

    public JLabelClignotant(String string, int alignement) {
        super(string, alignement);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Color couleur = getForeground();
                while(true) {
                    if (getForeground() == couleur) {
                        setForeground(getBackground());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JLabelClignotant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        setForeground(couleur);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JLabelClignotant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                }
            }
        }).start();
    }
}

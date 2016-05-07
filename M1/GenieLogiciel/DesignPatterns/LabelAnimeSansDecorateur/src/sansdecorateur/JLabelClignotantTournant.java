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
public class JLabelClignotantTournant extends JLabel {

    public JLabelClignotantTournant(String string) {
        this(string, JLabel.LEFT);
    }

    public JLabelClignotantTournant(String string, int alignement) {
        super(string, alignement);
        // Le thread qui fait clignoter
        new Thread(new Runnable() {

            public void run() {
                Color couleur = getForeground();
                while(true) {
                    if (getForeground() == couleur) {
                        setForeground(getBackground());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JLabelClignotantTournant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        setForeground(couleur);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JLabelClignotantTournant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    
                }
            }
        }).start();
        // Le thread qui fait tourner
        new Thread(new Runnable() {

            public void run() {
                while(true) {
                    setText(getText().substring(1)+getText().substring(0, 1));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JLabelTournant.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }
    

}

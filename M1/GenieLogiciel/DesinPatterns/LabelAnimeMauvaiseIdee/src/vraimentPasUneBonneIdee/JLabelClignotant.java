/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vraimentPasUneBonneIdee;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maillot
 */
public class JLabelClignotant extends Decorateur {

    public JLabelClignotant(JLabelAniméAbstrait composant) {
        super(composant);
        faireQuelqueChose();

    }

    @Override
    public void faireQuelqueChose() {
        super.faireQuelqueChose();
        faireClignoter();
    }


    private void faireClignoter() {
               new Thread(new Runnable() {

            @Override
            public void run() {
                Color couleur = getLabel().getForeground();
                while(true) {
                    if (getLabel().getForeground() == couleur) {
                        getLabel().setForeground(getLabel().getBackground());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JLabelClignotant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        getLabel().setForeground(couleur);
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

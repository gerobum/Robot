/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vraimentPasUneBonneIdee;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maillot
 */
public class JLabelTournant extends Decorateur {

    public JLabelTournant(JLabelAniméAbstrait composant) {
        super(composant);
        faireQuelqueChose();

    }

    @Override
    public final void faireQuelqueChose() {
        super.faireQuelqueChose();
        faireTourner();
    }

    private void faireTourner() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    getLabel().setText(getLabel().getText().substring(1)+getLabel().getText().substring(0, 1));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JLabelTournant.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();    }
}

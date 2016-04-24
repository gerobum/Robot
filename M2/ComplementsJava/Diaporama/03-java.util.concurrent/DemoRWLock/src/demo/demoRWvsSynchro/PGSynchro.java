
package demo.demoRWvsSynchro;

import java.awt.Color;
import javax.swing.JLabel;


public class PGSynchro implements PG {


    private final int DELAY = 1000;
 
    @Override
    public synchronized void get() {
        try {
            // Pour simuler une lecture longue
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public synchronized void put() {
        try {
            // Pour simuler une écriture longue
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
        }
    }
}

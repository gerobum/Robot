/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exo.demo.swing;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author maillot
 */
public class Ecrivain extends Thread {
    private final JLabel label;
    private final int nb;
    private final PG pg;
    Color eteint, allume;
    private static final Random random = new Random();
        
    public Ecrivain(JLabel label, PG pg, int nb, Color eteint, Color allume) {
        this.label = label;
        this.nb = nb;
        this.pg = pg;
        this.eteint = eteint;
        this.allume = allume;
    }

    @Override
    public void run() {
        for(int i = 0; i < nb; i++) {
            try {         
                label.setBackground(eteint);
                pg.put();
                label.setBackground(allume);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
            }            
        }
    }
    
    
}

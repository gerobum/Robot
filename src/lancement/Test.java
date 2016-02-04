/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lancement;

import robot.FramePrincipale;

/**
 *
 * @author Yvan
 */
public class Test {
    private static int niveau = 0;
    public static void main(String[] args) {
        niveau = 0;
        try {
            niveau = Integer.parseInt(args[0]);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FramePrincipale(niveau);
                }
            });
        } catch(Exception ex) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FramePrincipale();
                }
            });
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package partie2;

import partie2.LocalizedCalendar;
import javax.swing.JFrame;

/**
 *
 * @author maillot
 */
public class AfficheLocalizedCalendar extends JFrame {
    public AfficheLocalizedCalendar() {
        getContentPane().add(new LocalizedCalendar());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AfficheLocalizedCalendar();
    }

}

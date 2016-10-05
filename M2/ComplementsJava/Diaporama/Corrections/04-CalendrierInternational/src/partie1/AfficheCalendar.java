/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package partie1;

import javax.swing.JFrame;

/**
 *
 * @author maillot
 */
public class AfficheCalendar extends JFrame {
    public AfficheCalendar() {
        getContentPane().add(new JLabelCalendar());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AfficheCalendar();
    }

}

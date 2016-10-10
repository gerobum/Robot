/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import javax.swing.ImageIcon;
import robot.DansLeMur;
import javax.swing.JOptionPane;
import robot.Robot;

/**
 *
 * @author Yvan
 */
public class Lire extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;

    String message;
    String variable;

    public Lire(String variable, String message) {
        this.message = message;
        this.variable = variable;
        nom = variable + " = lire, " + message;
    }

    @Override
    public void go(robot.Robot robot) throws DansLeMur, InterruptedException {
        while (true) {
            try {
                String rep = JOptionPane.showInputDialog(null, message, "Nono vous demande", JOptionPane.INFORMATION_MESSAGE);
                ((InstructionComposee) getParent()).set(variable, Integer.parseInt(rep));
                return;
            } catch (NumberFormatException nfe) {
            }
        }

    }

    /*@Override
    public void set(Object o) {
    }*/

    @Override
    public ImageIcon getIcon() {
        return null;
    }
}

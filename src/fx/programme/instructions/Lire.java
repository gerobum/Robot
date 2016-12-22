package fx.programme.instructions;

import javax.swing.ImageIcon;
import fx.exceptions.DansLeMur;
import fx.robot.Robot;
import javax.swing.JOptionPane;

/**
 *
 * @author Yvan
 */
public class Lire extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;

    String message;
    String variable;

    public Lire(Instruction parent, String variable, String message) {
        super(parent);
        this.message = message;
        this.variable = variable;
        nom = variable + " = lire, " + message;
    }

    @Override
    public void go(Robot robot) throws DansLeMur, InterruptedException {
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

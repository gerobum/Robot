package fx.programme.instructions;

import fx.robot.Robot;
import javax.swing.ImageIcon;


/**
 *
 * @author Yvan
 */
public class Marque extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;

    public Marque(Instruction parent) {
        super(parent);
        nom = "marque";
    }
    @Override
    public void go(Robot robot) /*throws DansLeMur*/ {
        robot.poserUneMarque();
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

}

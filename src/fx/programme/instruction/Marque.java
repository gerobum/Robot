package fx.programme.instruction;

import fx.robot.Robot;
import javax.swing.ImageIcon;


/**
 *
 * @author Yvan
 */
public class Marque extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;
    //private transient Marqueur marqueur;
    public Marque() {
        nom = "marque";
        //this.marqueur = marqueur;
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

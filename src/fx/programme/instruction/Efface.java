package fx.programme.instruction;

import fx.robot.Robot;
import javax.swing.ImageIcon;


/**
 *
 * @author Yvan
 */
public class Efface extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;
    
    //private transient Marqueur marqueur;
    public Efface() {
        nom = "efface";
        //this.marqueur = marqueur;
    }
    @Override
    public void go(Robot robot) /*throws DansLeMur*/ {
        //marqueur.enleverUneMarque();
        robot.enleverUneMarque();
    }

    /*@Override
    public void set(Object o) {
        marqueur = (Marqueur) o;
    }*/

    @Override
    public ImageIcon getIcon() {
        return null;
    }

}

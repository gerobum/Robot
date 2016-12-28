package fx.programme.instructions;

import fx.robot.Robot;
import javax.swing.ImageIcon;


public class Efface extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;
    
    public Efface(Instruction parent) {
        super(parent);
        nom = "efface";
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

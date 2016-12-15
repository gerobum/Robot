package fx.programme.instruction;

import fx.robot.DansLeMur;
import fx.robot.Robot;
import javax.swing.ImageIcon;


public class Avance extends InstructionElementaire {
    private static final long serialVersionUID = 1L;
    
    //private transient Avancable avancable;
    public Avance() {
        nom = "avance";
        //this.avancable = avancable;
    }
    @Override
    public void go(Robot robot) throws InterruptedException {
        synchronized(robot) {
            while(robot.isStopped())
                robot.wait();
        }
        robot.avance();
    }

    /*@Override
    public void set(Object o) {
        avancable = (Avancable) o;
    }*/

    @Override
    public ImageIcon getIcon() {
        return null;
    }
}

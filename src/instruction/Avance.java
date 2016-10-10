/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

import javax.swing.ImageIcon;
import robot.DansLeMur;


/**
 *
 * @author Yvan
 */
public class Avance extends InstructionElementaire {
    private static final long serialVersionUID = 1L;
    
    //private transient Avancable avancable;
    public Avance() {
        nom = "avance";
        //this.avancable = avancable;
    }
    @Override
    public void go(robot.Robot robot) throws DansLeMur, InterruptedException {
        synchronized(robot) {
            while(robot.isStopped())
                robot.wait();
        }
        robot.avance();
        //avancable.avance();
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

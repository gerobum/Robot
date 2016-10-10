/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import javax.swing.ImageIcon;

/**
 *
 * @author Yvan
 */
public class Tourne extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;
    //private transient Tournable tournable;

    public Tourne() {
        nom = "tourne";
    }

    @Override
    public void go(robot.Robot robot) throws InterruptedException {
        synchronized (robot) {
            while (robot.isStopped()) {
                robot.wait();
            }
        }
        robot.tourne();
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }
}

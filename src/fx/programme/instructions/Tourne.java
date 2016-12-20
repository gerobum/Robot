package fx.programme.instructions;

import fx.robot.Robot;
import javax.swing.ImageIcon;

/**
 *
 * @author Yvan
 */
public class Tourne extends InstructionElementaire {
    
    private static final long serialVersionUID = 1L;

    public Tourne(Instruction parent) {
        super(parent);
        nom = "tourne";
    }

    @Override
    public void go(Robot robot) throws InterruptedException {
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

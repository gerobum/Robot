package fx.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;



/**
 *
 * @author Yvan
 */
public class DevantMarque extends ExprBoolElt {
    //private transient Robot robot;
    //public DevantMarque(Robot robot) {
    //    this.robot = robot;
    //}
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant != null && devant instanceof terrain.Marque;
    }
    @Override
    public String toString() {
        return "devant marque";
    }


    //@Override
    //public void set(Object o) {
    //    robot = (Robot) o;
    //}

    @Override
    public String getAbr() {
        return "dmq";
    }

}

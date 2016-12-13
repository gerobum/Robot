package fx.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;

/**
 *
 * @author Yvan
 */
public class PasDevantMarque extends ExprBoolElt {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant == null || !(devant instanceof terrain.Marque);
    }
    @Override
    public String toString() {
        return "pas devant marque";
    }

    @Override
    public String getAbr() {
        return "pdmq";
    }


}

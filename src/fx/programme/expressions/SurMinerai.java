package fx.programme.expressions;

import fx.terrain.Minerai;
import fx.robot.Robot;
import fx.terrain.Cellule;

/**
 *
 * @author Yvan
 */
public class SurMinerai extends ExprBoolElt {
    private static final long serialVersionUID = 1L;
    @Override
    public boolean evalue(Robot robot) {
        Cellule dessous = robot.quoiDessous();
        return dessous != null && dessous instanceof Minerai;
    }
    @Override
    public String toString() {
        return "sur minerai";
    }

    @Override
    public String getAbr() {
        return "smn";
    }

}
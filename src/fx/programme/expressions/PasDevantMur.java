package fx.programme.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;
import fx.terrain.Mur;

public class PasDevantMur extends ExprBoolElt {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant == null || !(devant instanceof Mur);
    }
    @Override
    public String toString() {
        return "pas devant mur";
    }

    @Override
    public String getAbr() {
        return "pdmr";
    }
}

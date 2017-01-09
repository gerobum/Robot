package fx.programme.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;
import fx.terrain.Mur;
import fx.terrain.Trou;

public class PasAuBordDuPrecipice extends ExprBoolElt {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant == null || devant.getClass() != Trou.class;
    }
    @Override
    public String toString() {
        return "pas au bord du précipice";
    }

    @Override
    public String getAbr() {
        return "pabp";
    }
}

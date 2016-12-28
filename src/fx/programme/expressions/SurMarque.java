package fx.programme.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;

public class SurMarque extends ExprBoolElt {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {
        Cellule dessous = robot.quoiDessous();
        return dessous != null && dessous instanceof terrain.Marque;
    }
    @Override
    public String toString() {
        return "sur marque";
    }

    @Override
    public String getAbr() {
        return "smq";
    }

}

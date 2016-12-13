package fx.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;

/**
 *
 * @author Yvan
 */
public class PasSurMarque extends ExprBoolElt {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean evalue(Robot robot) {

        Cellule dessous = robot.quoiDessous();
        return dessous == null || !(dessous instanceof terrain.Marque);
    }
    @Override
    public String toString() {
        return "pas sur marque";
    }

    @Override
    public String getAbr() {
        return "psmq";
    }

}

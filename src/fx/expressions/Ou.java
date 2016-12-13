package fx.expressions;

import fx.robot.Robot;

/**
 *
 * @author Yvan
 */
public class Ou extends OperationBool {
    private static final long serialVersionUID = 1L;

    public Ou(ExprBool gauche, ExprBool droite, String nom) {
        super(gauche, droite, nom);
    }

    @Override
    public boolean evalue(Robot robot) {
        return gauche.evalue(robot) || droite.evalue(robot);
    }

}

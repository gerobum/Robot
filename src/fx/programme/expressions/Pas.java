package fx.programme.expressions;

import fx.robot.Robot;

public class Pas extends OperationBool {
    private static final long serialVersionUID = 1L;

    public Pas(ExprBool droite, String nom) {
        super(droite, nom);
    }
    @Override
    public boolean evalue(Robot robot) {
        return !droite.evalue(robot);
    }

}

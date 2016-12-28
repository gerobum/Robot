package fx.programme.expressions;

import fx.robot.Robot;

public class Et extends OperationBool {

    public static final long serialVersionUID = 0L;
    
    public Et(ExprBool gauche, ExprBool droite, String nom) {
        super(gauche, droite, nom);
    }

    @Override
    public boolean evalue(Robot robot) {
        return gauche.evalue(robot) && droite.evalue(robot);
    }

}

package fx.programme.expressions;

import java.io.Serializable;
import java.util.Random;
import fx.robot.Robot;

public abstract class ExprBool implements Serializable {
    
    public static Random random = new Random();
    
    
    
    public abstract boolean evalue(Robot robot);
    public static final long serialVersionUID = 0L;

}

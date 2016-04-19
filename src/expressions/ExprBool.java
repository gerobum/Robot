/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

import java.io.Serializable;
import java.util.Random;
import robot.Robot;

/**
 *
 * @author Yvan
 */
public abstract class ExprBool implements Serializable {
    
    public static Random random = new Random();
    
    
    
    public abstract boolean evalue(Robot robot);
    //public abstract void set(Object o);
    public static final long serialVersionUID = 0L;

}

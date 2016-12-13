/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fx.expressions;

import fx.robot.Robot;

/**
 *
 * @author Yvan
 */
public class Et extends OperationBool {

    public static final long serialVersionUID = 0L;
    
    public Et(ExprBool gauche, ExprBool droite, String nom) {
        super(gauche, droite, nom);
    }
/*
    @Override
    protected boolean operation(boolean gauche, boolean droite) {
        return gauche && droite;
    }

    @Override
    protected boolean operation(boolean droite) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
*/
    /*@Override
    public void set(Object o) {
        gauche.set(o);
        droite.set(o);
    }*/

    @Override
    public boolean evalue(Robot robot) {
        return gauche.evalue(robot) && droite.evalue(robot);
    }

}

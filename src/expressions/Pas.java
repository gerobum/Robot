/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

import robot.Robot;

/**
 *
 * @author Yvan
 */
public class Pas extends OperationBool {
    private static final long serialVersionUID = 1L;

    public Pas(ExprBool droite, String nom) {
        super(droite, nom);
    }
/*
    @Override
    protected boolean operation(boolean gauche, boolean droite) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean operation(boolean droite) {
        return !droite;
    }

    @Override
    public void set(Object o) {
        droite.set(o);
    }*/

    @Override
    public boolean evalue(Robot robot) {
        return !droite.evalue(robot);
    }

}

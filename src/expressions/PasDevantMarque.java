/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

import robot.Robot;
import terrain.Cellule;

/**
 *
 * @author Yvan
 */
public class PasDevantMarque extends ExprBoolElt {
    private static final long serialVersionUID = 1L;
    //private transient Robot robot;
    //public PasDevantMarque(Robot robot) {
    //    this.robot = robot;
    //}

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant == null || !(devant instanceof terrain.Marque);
    }
    @Override
    public String toString() {
        return "pas devant marque";
    }

    /*@Override
    public void set(Object o) {
        robot = (Robot) o;
    }*/

    @Override
    public String getAbr() {
        return "pdmq";
    }


}

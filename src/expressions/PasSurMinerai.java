/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressions;

import terrain.Minerai;
import robot.Robot;
import terrain.Cellule;

/**
 *
 * @author Yvan
 */
public class PasSurMinerai extends ExprBoolElt {
    private static final long serialVersionUID = 1L;
    //private transient Robot robot;

    //public PasSurMinerai(Robot robot) {
    //    this.robot = robot;
    //}

    @Override
    public boolean evalue(Robot robot) {
        Cellule dessous = robot.quoiDessous();
        return dessous == null || !(dessous instanceof Minerai);
    }

    @Override
    public String toString() {
        return "pas sur minerai";
    }
/*
    @Override
    public void set(Object o) {
        robot = (Robot) o;
    }*/

    @Override
    public String getAbr() {
        return "psmn";
    }
}

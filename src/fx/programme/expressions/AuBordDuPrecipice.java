package fx.programme.expressions;

import fx.robot.Robot;
import fx.terrain.Cellule;
import fx.terrain.Trou;
 
public class AuBordDuPrecipice extends ExprBoolElt {

    @Override
    public String toString() {
        return "au bord du précipice";
    }


    @Override
    public String getAbr() {
        return "abp";
    }

    @Override
    public boolean evalue(Robot robot) {
        Cellule devant = robot.quoiDevant();
        return devant != null && devant.getClass() == Trou.class;
    }

}

package fx.programme.instructions;

import fx.programme.NoeudProgramme;
import fx.robot.DansLeMur;
import fx.robot.Robot;



/**
 *
 * @author Yvan
 */
public abstract class Instruction extends NoeudProgramme {

    public static final long serialVersionUID = 0L;
    protected String nom;

    public abstract void go(Robot robot) throws DansLeMur, InterruptedException;

    @Override
    public String toString() {
        if (getParent() != null) {
            if (getParent().getClass() == Si.class) {
                if (getParent().getIndex(this) == 0) {
                    return "alors " + nom;
                } else {
                    return "sinon " + nom;
                }
            } else if (getParent().getClass() == TantQue.class || getParent().getClass() == Pour.class) {
                return "faire " + nom;
            }
        }
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract boolean autorisationAjout();

    public abstract String deepToString(String decalage);
}

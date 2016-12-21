package fx.programme.instructions;

import fx.robot.DansLeMur;
import fx.robot.Robot;
import java.util.*;
import javafx.scene.control.TreeItem;
import javax.swing.ImageIcon;

/**
 *
 * @author Yvan
 */
public abstract class Instruction {

    public static final long serialVersionUID = 0L;
    protected String nom;
    private final Instruction PARENT;
    private final ArrayList<Instruction> ENFANTS;

    public Instruction(Instruction parent) {
        this.PARENT = parent;
        ENFANTS = new ArrayList<>();
    }

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

    public Instruction getParent() {
        return PARENT;
    }

    public abstract boolean autorisationAjout();

    public abstract String deepToString(String decalage);

    public abstract ImageIcon getIcon();

    public abstract void go(Robot robot) throws DansLeMur, InterruptedException;

    public int getIndex(Instruction instruction) {
        return ENFANTS.indexOf(instruction);
    }

    public int getChildCount() {
        return ENFANTS.size();
    }

    public Instruction getChildAt(int i) {
        return ENFANTS.get(i);
    }

    public Instruction getFirstChild() {
        if (ENFANTS.size() > 0) {
            return ENFANTS.get(0);
        } else {
            return null;
        }
    }
}

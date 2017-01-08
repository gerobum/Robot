package fx.programme.instructions;

import fx.exceptions.AjoutImpossible;
import fx.exceptions.DansLeMur;
import fx.robot.Robot;
import java.util.*;
import javax.swing.ImageIcon;

public abstract class Instruction implements Cloneable {

    public static final long serialVersionUID = 0L;
    protected String nom;
    private Instruction PARENT;
    private ArrayList<Instruction> ENFANTS;

    public Instruction(Instruction parent) {
        this.PARENT = parent;
        ENFANTS = new ArrayList<>();
    }

    @Override
    public String toString() {
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

    public int getChildrenCount() {
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

    public void addChild(int p, Instruction instruction) throws AjoutImpossible {
        if (!autorisationAjout()) {
            throw new AjoutImpossible();
        }
        ENFANTS.add(p, instruction);
        System.out.println(ENFANTS.size());
    }

    public void addChild(Instruction instruction) throws AjoutImpossible {
        if (!autorisationAjout()) {
            throw new AjoutImpossible();
        }
        ENFANTS.add(instruction);
    }

    public void remove(Instruction instruction) {
        ENFANTS.remove(instruction);
    }
    
    @Override
    public Instruction clone() {
        try {
            Instruction instruction = (Instruction) super.clone();
            instruction.PARENT = null;
            instruction.ENFANTS = (ArrayList<Instruction>) ENFANTS.clone();
            for(int i = 0; i < ENFANTS.size(); ++i) {
                instruction.ENFANTS.set(i, ENFANTS.get(i).clone());
            }
            
            return instruction;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}

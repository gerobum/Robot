/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import robot.DansLeMur;
import robot.NoeudProgramme;

/**
 *
 * @author Yvan
 */
public abstract class Instruction extends NoeudProgramme {

    public static final long serialVersionUID = 0L;
    protected String nom;

    public abstract void go(robot.Robot robot) throws DansLeMur, InterruptedException;

    @Override
    public String toString() {
        if (getParent() != null) {
            if (getParent() instanceof Si) {
                if (getParent().getIndex(this) == 0) {
                    return "alors " + nom;
                } else {
                    return "sinon " + nom;
                }
            } else if (getParent() instanceof TantQue || getParent() instanceof Pour) {
                return "faire " + nom;
            }
        }
        return nom;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Permet de changer éventuellement l'objet sur lequel s'applique
     * l'instruction
     *
     * @param o
     */
    //public abstract void set(Object o);

    public abstract boolean autorisationAjout();

    public abstract String deepToString(String decalage);
}

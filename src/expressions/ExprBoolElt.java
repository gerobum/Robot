/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

/**
 *
 * @author Yvan
 */
public abstract class ExprBoolElt extends ExprBool {
    protected String nom;
    /** Permet de changer éventuellement l'objet sur lequel
     * s'applique l'instruction
     * @param o
     */
    public abstract String getAbr();

    @Override
    public String toString() {
        return nom;
    }

    public String getNom() {
        return toString().replace(' ', '_');
    }


}

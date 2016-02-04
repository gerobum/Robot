/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expressions;

/**
 *
 * @author Yvan
 */
public abstract class OperationBool extends ExprBool {
    protected ExprBool gauche;
    protected ExprBool droite;
    private String nom;

    public OperationBool(ExprBool gauche, ExprBool droite, String nom) {
        this.nom = nom;
        this.gauche = gauche;
        this.droite = droite;
    }
    public OperationBool(ExprBool droite, String nom) {
        this(null, droite, nom);
    }
/*
    protected abstract boolean operation(boolean gauche, boolean droite);
    protected abstract boolean operation(boolean droite);

    @Override
    public boolean evalue() {
        if (gauche == null)
            return operation(droite.evalue());
        else
            return operation(gauche.evalue(), droite.evalue());
    }**/

    @Override
    public String toString() {
        return nom;
    }

}

package fx.programme.expressions;

/**
 *
 * @author Yvan
 */
public abstract class ExprBoolElt extends ExprBool {
    public static final long serialVersionUID = 0L;
    protected String nom;
    /** Permet de changer éventuellement l'objet sur lequel
     * s'applique l'instruction
     * @param o
     * @return 
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

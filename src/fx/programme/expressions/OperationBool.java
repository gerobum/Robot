package fx.programme.expressions;

/**
 *
 * @author Yvan
 */
public abstract class OperationBool extends ExprBool {
    public static final long serialVersionUID = 0L;
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

    @Override
    public String toString() {
        return nom;
    }

}

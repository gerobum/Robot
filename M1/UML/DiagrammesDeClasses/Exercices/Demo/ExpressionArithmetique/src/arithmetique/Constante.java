package arithmetique;

public class Constante  extends Expression {
    private final double valeur;

    public Constante(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public double evaluer() {
        return valeur;
    }
}

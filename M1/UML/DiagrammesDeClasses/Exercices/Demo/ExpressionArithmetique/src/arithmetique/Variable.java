package arithmetique;

public class Variable extends Expression {
    private double valeur;

    public Variable(double valeur) {
        this.valeur = valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }    

    @Override
    public double evaluer() {
        return valeur;
    }
    
}

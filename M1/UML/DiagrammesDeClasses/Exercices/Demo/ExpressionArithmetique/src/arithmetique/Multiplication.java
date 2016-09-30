package arithmetique;

public class Multiplication extends Operation {

    public Multiplication(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public double evaluer() {
        return gauche.evaluer() * droite.evaluer();
    }
    
}

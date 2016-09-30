package arithmetique;

public class Soustraction extends Operation {

    public Soustraction(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public double evaluer() {
        return gauche.evaluer() - droite.evaluer();
    }
    
}

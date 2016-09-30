package arithmetique;

public class Addition extends Operation {

    public Addition(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public double evaluer() {
        return gauche.evaluer() + droite.evaluer();
    }
    
}

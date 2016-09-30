package arithmetique;

public class Division extends Operation {

    public Division(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public double evaluer() {
        return gauche.evaluer() / droite.evaluer();
    }
    
}

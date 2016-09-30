package arithmetique;

public class Opposition extends Operation {

    public Opposition(Expression droite) {
        super(droite);
    }

    @Override
    public double evaluer() {
        return -droite.evaluer();
    }
    
}

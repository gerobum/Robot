package exemplepatronDecorateur;
public class DecorateurConcretB extends Decorateur {
    public DecorateurConcretB(Composant composant) {
        super(composant);
    }
    @Override
    public String toString() {
        return super.toString() + "B ";
    }    
}

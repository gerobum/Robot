package exemplepatronDecorateur;
public class DecorateurConcretA extends Decorateur {
    public DecorateurConcretA(Composant composant) {
        super(composant);
    }
    @Override
    public String toString() {
        return super.toString() + "A ";
    } 
}

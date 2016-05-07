package exemplepatronDecorateur;

public class Decorateur extends Composant {

  protected Composant composant;

  public Decorateur(Composant composant) {
    this.composant = composant;
  }

  @Override
  public String toString() {
    return composant.toString();
  }
}

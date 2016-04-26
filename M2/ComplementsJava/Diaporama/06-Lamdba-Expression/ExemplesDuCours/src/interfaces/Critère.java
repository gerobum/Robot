package interfaces;

import personne.Personne;

@FunctionalInterface
public interface Critère {
    boolean valider(Personne p);
    default void uneAutreMethode(Personne p) {
        System.out.println("defaut " + p);
    }
}

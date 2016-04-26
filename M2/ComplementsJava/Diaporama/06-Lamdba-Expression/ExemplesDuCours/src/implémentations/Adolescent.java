package implémentations;

import interfaces.Critère;
import personne.Personne;

public class Adolescent implements Critère {

    @Override
    public boolean valider(Personne p) {
        return p.genre == Personne.Genre.GARCON
                && p.getAge() >= 13
                && p.getAge() < 20;
    }
}

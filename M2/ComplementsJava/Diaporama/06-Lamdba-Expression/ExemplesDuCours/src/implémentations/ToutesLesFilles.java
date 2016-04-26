
package implémentations;

import interfaces.Critère;
import personne.Personne;


public class ToutesLesFilles implements Critère {
    @Override
    public boolean valider(Personne p) {
        return p.genre == Personne.Genre.FILLE;
    }
}

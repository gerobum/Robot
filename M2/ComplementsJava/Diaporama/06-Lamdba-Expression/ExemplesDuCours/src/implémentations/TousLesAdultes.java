package implémentations;

import interfaces.Critère;
import personne.Personne;

/*
 *
 * @author yvan
 */
public class TousLesAdultes implements Critère {

    @Override
    public boolean valider(Personne p) {
        return p.getAge() >= 18;
    }

}

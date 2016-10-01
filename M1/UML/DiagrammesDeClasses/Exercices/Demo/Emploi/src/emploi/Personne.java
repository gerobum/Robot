package emploi;

import java.util.HashSet;
import java.util.Set;

public class Personne {
    public final String nom;
    public final Set<Emploi> emploi;

    public Personne(String nom) {
        this.nom = nom;
        emploi = new HashSet<>();
    }
    
    public void ajouter(Emploi emp) {
        emploi.add(emp);
    }
    
    
}

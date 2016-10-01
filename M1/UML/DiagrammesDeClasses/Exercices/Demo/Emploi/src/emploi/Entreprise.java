package emploi;

import java.util.HashSet;
import java.util.Set;

public class Entreprise {
    public final String nom;
    public final Set<Emploi> emploi;

    public Entreprise(String nom) {
        this.nom = nom;
        emploi = new HashSet<>();
    }
    
    public void add(String nomPoste, Personne employé) {
        Emploi emp = new Emploi(nomPoste, employé, this);
        
        emploi.add(emp);
        
    }
    
    public void add(String nomPoste, String nomEmployé) {
        add(nomPoste, new Personne(nomEmployé));        
    }
}

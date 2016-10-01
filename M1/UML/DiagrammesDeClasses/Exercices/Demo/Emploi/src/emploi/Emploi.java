package emploi;

public class Emploi {
    public final String nom;
    public final Personne employé;
    public final Entreprise entreprise;

    public Emploi(String nom, Personne employé, Entreprise entreprise) {
        this.nom = nom;
        this.employé = employé;
        this.entreprise = entreprise;
        this.entreprise.add(nom, employé);
    }
    
    
}

package main;

import emploi.Entreprise;
import emploi.Emploi;
import emploi.Personne;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Personne> personne = new HashSet<>();
        Set<Entreprise> entreprise = new HashSet<>();

        
        Personne p;
        Entreprise e;
        Entreprise a;
        Entreprise b;
        
        p = new Personne("a1");
        personne.add(p);
        e = new Entreprise("A");
        a = e;
        entreprise.add(e);
        a.add("A1", p);
        
        
        
        p = new Personne("a2");
        personne.add(p);
        a.add("A2", p);
        
        
        
        p = new Personne("b1");
        personne.add(p);
        e = new Entreprise("B");
        b = e;
        entreprise.add(e);
        b.add("B1", p);
        
        
        
        p = new Personne("ab1");
        personne.add(p);
        a.add("A2", p);
        b.add("B2", p);
        
        
        
        System.out.println("Les employés par entreprise");
        for(Entreprise ep : entreprise) {
            System.out.println("---------");
            System.out.println("Entreprise " + ep.nom);
            System.out.println("---------");
            for(Emploi empl : ep.emploi) {
                System.out.println("Emploie " + empl.employé.nom);
            }
        }
        
    }
}

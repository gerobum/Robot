package main;

import emploi.Emploi;
import emploi.Entreprise;
import emploi.Personne;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Personne> personne = new HashSet<>();
        Set<Entreprise> entreprise = new HashSet<>();
        Set<Emploi> emploi = new HashSet<>();
        
        Personne p;
        Entreprise e;
        Entreprise a;
        Entreprise b;
        
        p = new Personne("a1");
        personne.add(p);
        e = new Entreprise("A");
        a = e;
        entreprise.add(e);
        
        emploi.add(new Emploi("P1", p, e));
        
        p = new Personne("a2");
        personne.add(p);
        
        emploi.add(new Emploi("P1", p, e));
        
        p = new Personne("b1");
        personne.add(p);
        e = new Entreprise("B");
        b = e;
        entreprise.add(e);
        
        emploi.add(new Emploi("P2", p, e));
        
        p = new Personne("ab1");
        personne.add(p);
        
        emploi.add(new Emploi("P1a", p, a));
        emploi.add(new Emploi("P1b", p, b));
        
        System.out.println("Les employés par entreprise");
        for(Entreprise ep : entreprise) {
            System.out.println("---------");
            System.out.println(ep.nom);
            for(Emploi empl : ep.emploi) {
                System.out.println(empl.employé.nom);
            }
        }
        
    }
}

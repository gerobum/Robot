/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.istack.internal.NotNull;
import implémentations.Adolescent;
import implémentations.ToutesLesFilles;
import interfaces.Bidon;
import interfaces.Chercheur;
import interfaces.Salutation;
import interfaces.Critère;
import interfaces.Operation;
import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import personne.Personne;

/**
 *
 * @author yvan
 */
public class Main {

    static Operation<Integer, Integer, Integer> pgcd;

    public static void envoyerSelonCritère(List<Personne> personne, String msg,
            Critère critère) {
        for (Personne p : personne) {
            if (critère.valider(p)) {
                p.envoyerMessage(msg);
            }
        }
    }

    public static void ouEnSommesNous(Personne p, Critère critère, String msg) {
        if (critère.valider(p)) {
            System.out.println("Bonjour " + p + " Vous avez moins de 50 ans");
        } else {
            System.out.println("Bonjour " + p + "Vous avez plus de 50 ans");
        }
        critère.uneAutreMethode(p);
    }

    public static void envoyerAuxAdultes(List<Personne> personne, String msg) {
        for (Personne p : personne) {
            if (p.getAge() >= 18) {
                p.envoyerMessage(msg);
            }
        }
    }

    public static <T, U, R> void afficheCalcul(T a, U b, final Operation<T, U, R> op) {
        System.out.println(op.calcul(a, b));
    }

    public static void main(String[] args) {
        List<Personne> liste = new LinkedList<>();

        for (int i = 0; i < 100; ++i) {
            liste.add(new Personne());
        }

        envoyerAuxAdultes(liste, "Hello");
        envoyerSelonCritère(liste, "Hello", new ToutesLesFilles());
        envoyerSelonCritère(liste, "Hello", new Adolescent());
        envoyerSelonCritère(liste, "Les jeunes...",
                p -> p.getAge() >= 13 && p.getAge() < 20);

        ouEnSommesNous(new Personne(), x -> x.getAge() < 50, "...");

        Predicate<String> estvide = String::isEmpty;
        BinaryOperator<Integer> soustraction = (a, b) -> a - b;
        BinaryOperator<Double> hyp = Math::hypot;

        Chercheur<Integer> min = (l) -> {
            Iterator<Integer> i = l.iterator();
            Integer x = i.next();
            while (i.hasNext()) {
                Integer y = i.next();
                if (y < x) {
                    x = y;
                }
            }
            return x;
        };
        @NotNull Salutation c;
        c = () -> {
            System.out.println("coucou");
        };
        c.salutation();
        Critère lesAdultes = p -> p.getAge() >= 18;
        Critère lesFilles = p -> p.genre == Personne.Genre.FILLE;
        Critère lesPalindroNommés = p -> {
            String nom = p.nom.toLowerCase();
            for(int i = 0, j = nom.length()-1; i < j; i++, j--)
                if (nom.charAt(i) != nom.charAt(j))
                    return false;
            return true;
        };

        Salutation familier = () -> {
            System.out.println("Ciao");
        };

        Salutation soutenu = () -> {
            System.out.println("Je vous prie de bien vouloir accepter dans votre "
                    + "haute bienveillance mes plus respectueuses salutations");
        };

        Operation<Double, Double, Double> op;

        op = (a, b) -> a + b;

        afficheCalcul(1.0, 2.0, op);

        op = Math::atan2;

        afficheCalcul(1.0, 2.0, op);

        op = Math::min;
        afficheCalcul(1.0, 2.0, op);
        System.out.println("----------------------");
        // Référence à une lambda-expression
        afficheCalcul(1, 2, (a, b) -> a - b);
        // Référence à une méthode statique
        afficheCalcul(1, 2, Math::max);
        // Référence à une méthode d'instance d'un objet donné
        //afficheCalcul("([Jvmr\\s])([aeoui])", "$1av$2", "Java 5 est mort, vive Java 6"::replaceAll);
        afficheCalcul("([JVv])([aei])", "$1av$2", "Vive Java"::replaceAll);
        // Référence à une méthode d'instance d'un objet quelconque d'un type donné
        afficheCalcul("Vive Java", 5, String::charAt);
        afficheCalcul(new Random(), 6, Random::nextInt/*, "tirage de dés"*/);
        // Référence à un constructeur
        afficheCalcul(22*256*256+33*256+44, true, Color::new);

        pgcd = (Integer a, Integer b) -> {
            if (b == 0) {
                return a;
            } else if (a < b) {
                return pgcd.calcul(b, a);
            } else {
                return pgcd.calcul(a - b, b);
            }
        };
        // Récursivité
        afficheCalcul(12, 114, pgcd);
        

        /*System.out.println(op.operation(5.0, 6.0));
        
        
        
         Machin machin = "azerty"::charAt;
        
         System.out.println(machin.n(2));*/
        
        Bidon b = () -> (double)4;
        
    }
}

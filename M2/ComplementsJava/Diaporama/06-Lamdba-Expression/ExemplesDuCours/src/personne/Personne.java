/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personne;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

/**
 *
 * @author maillot
 */
public class Personne {

    public enum Genre {

        GARCON, FILLE
    }
    public final String nom;
    public final Date naissance;
    public final Genre genre;
    public final String email;
    public final int age;
    private static int num = 0;
    private static final Random random = new Random(0);

    public Personne() {
        naissance = new Date();
        genre = Genre.values()[random.nextInt(2)];
        age = random.nextInt(125);
        email = "";
        ++num;
        nom = ((genre == Genre.FILLE) ? "F" : "G") + num + "";
    }

    public int getAge() {
        return age;
    }

    public void envoyerMessage(String msg) {
        System.out.println(msg + " -> \"" + toString() + "\"");
    }

    @Override
    public String toString() {
        return nom + ", " + age + " ans," + genre.name().toLowerCase();
    }
}

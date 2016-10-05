package exo;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * Ce programme est utilisé pour comparer deux Map thread-safe :
    1. ReadWriteMap
    2. SynchronizedMap
    Les deux excluent mutuellement lecture et écriture, mais la première
    admet les lectures multiples, contrairement à l'autre.

    La Map<Integer, Double> associe un entier à sa moitié (pourquoi pas ?)
    La Map est partagée entre plusieurs écrivains et plusieurs lecteurs.

 * @author maillot
 */
public class TestMain {

    // Mettre en commentaire tour à tour l'une des deux lignes suivantes
    // Lancer le programme pour les deux cas et comparer le temps mis
    // par chacun.
    private static final Map<Integer, Double> rwm = new SynchronizedMap<>(2);
    // private static final Map<Integer, Double> rwm = new ReadWriteMap<>(2);
    private static final Random RANDOM = new Random();
    private static final int DIM = 50;

    public static void lanceEcrivain(final int n) {
        // Un écrivain tire au hasard tire au hasard une clé dans un intervalle
        // défini et l'associe à sa moitié.
        // Ce thread tourne tant que toutes les clés de l'intervalle n'ont pas
        // été choisies.
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (rwm.size() < DIM) {
                    int k = RANDOM.nextInt(DIM);
                    int size = rwm.size();
                    rwm.put(k, k / 2.0);
                    System.err.println("\n\n("+size+"), E" + n + " -> [" + k + " => " + k / 2.0+ "], (" + rwm.size() + ")\n");
                }
                System.err.println("Fin de l'écrivain n°" + n);
            }
        }).start();
    }

    public static void lanceLecteur(final int n) {

        new Thread(new Runnable() {
            // Un lecteur tire au hasard une clé et affiche la clé et sa moitié.
            @Override
            public void run() {
                while (rwm.size() < DIM) {
                    int k = RANDOM.nextInt(DIM);
                    Double lu = rwm.get(k);
                    System.err.print("L"+n+ " <- [" + k + " => " + lu + "], (" + rwm.size() + ") |");
                }
                System.err.println("Fin du lecteur n°" + n);
            }
        }).start();
    }

    public static void main(String[] args) {
        //Scanner clavier = new Scanner(System.in);
        int ne, nl;
        //System.out.print("Combien de lecteurs : ");
        // nl = clavier.nextInt();
        nl = 20;
        //System.out.print("Combien d'écrivains : ");
        //ne = clavier.nextInt();
        ne = 2;
        for (int i = 1; i <= nl; i++) {
            lanceLecteur(i);
        }

        for (int i = 1; i <= ne; i++) {
            lanceEcrivain(i);
        }
    }

}

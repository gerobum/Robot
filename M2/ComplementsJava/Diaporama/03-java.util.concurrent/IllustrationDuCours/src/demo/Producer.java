/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author maillot
 */
public class Producer extends Thread {

    private BlockingDeque<Double> queue;
    private String name;
    private int delta;
    private Random random = new Random();
    private int combien;
    private Afficheur afficheur;

    /**
     * Un producteur qui produit des valeurs de type double dans une queue
     * bloquante. Le nombre de valeurs produites est défini par le paramètre
     * combien. Le temps d'attente entre deux productions est défini par le
     * paramètre delta.
     *
     * @param queue la queue bloquante dans laquelle produire les valeurs
     * @param name un nom pour le producteur
     * @param delta l'intervalle de temps entre deux productions
     * @param combien le nombre de valeurs à produire.<br> Si combien < 0 alors
     * une infinité de valeurs est produite. la première 1.0 et les suivantes
     * augmentent de 1 en 1. <br> Si combien >=0, c'est le nombre de valeurs à
     * produire. Elles sont choisies aléatoirement dans [0,1[.
     * @param daemon Le thread de production est démon ou pas.
     */
    public Producer(BlockingDeque<Double> queue, String name, int delta, int combien, boolean daemon, Afficheur afficheur) {
        this.queue = queue;
        this.name = name;
        this.delta = delta;
        this.combien = combien;
        setDaemon(daemon);
        this.afficheur = afficheur;
    }

    public Producer(BlockingDeque<Double> queue, String name, int delta, int combien, boolean daemon) {
        this(queue, name, delta, combien, daemon, null);

        afficheur = new Afficheur() {
            @Override
            public void afficher(String name, double v) {
                System.out.println(name + " a produit " + v);
            }
        };
    }

    /**
     * Un production qui produit des valeurs de type double dans une queue
     * bloquante. Les valeurs produites sont dans [0,1[. Le nombre de valeurs
     * produites est infini. Le temps d'attentes entre deux productions est
     * défini par le paramètre delta.
     *
     * @param queue la queue bloquante dans laquelle produire les valeurs
     * @param name un nom pour le producteur
     * @param delta l'intervalle de temps entre deux productions
     */
    public Producer(LinkedBlockingDeque<Double> queue, String name, int delta) {
        this(queue, name, delta, -1, false, null);
        afficheur = new Afficheur() {
            @Override
            public void afficher(String name, double v) {
                System.out.println(name + " a produit " + v);
            }
        };
    }

    @Override
    public void run() {
        if (combien > 0) {
            for (int i = 0; i < combien; i++) {
                try {
                    if (afficheur != null) {
                        afficheur.afficher(name, i + 1.0);
                    }
                    queue.put(i + 1.0);
                    Thread.sleep(delta);
                } catch (InterruptedException ex) {
                }
            }
        } else {
            while (true) {
                try {
                    Double valeurProduite = random.nextDouble();
                    if (afficheur != null) {
                        afficheur.afficher(name, valeurProduite);
                    }
                    queue.put(valeurProduite);
                    Thread.sleep(delta);
                } catch (InterruptedException ex) {
                }
            }
        }
        System.out.println("Fin de production");
    }
}

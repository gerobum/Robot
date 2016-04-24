/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Vector;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author maillot
 */
public class Consumer extends Thread {

    private BlockingDeque<Double> queue;
    private String name;
    private int delta;
    private Afficheur afficheur;
    Vector v;
    ConcurrentLinkedDeque cld;

    public void setAfficheur(Afficheur afficheur) {
        this.afficheur = afficheur;
    }

    /**
     * Un consommateur qui consomme des valeurs d'une file bloquante.
     * @param queue la file dans laquelle consommer des valeurs.
     * @param name un nom pour le consommateur
     * @param delta l'intervalle de temps entre deux consommations.
     * @param afficheur Une interface pour définir la façon d'afficher les résutats.
     */
    public Consumer(BlockingDeque<Double> queue, String name, int delta, Afficheur afficheur) {
        this.queue = queue;
        this.name = name;
        this.delta = delta;
        this.afficheur = afficheur;
    }
    
    public String getConsumerName() {
        return name;
    }


    /**
     * Pour mettre fin au consommateur en cas d'attente trop longue.
     * @param duration le temps d'attente.
     * @return 
     */
    private Thread toFinishIfWaitingTooMuch(final int duration) {
        return new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(duration);
                    Consumer.this.interrupt();
                } catch (InterruptedException ex) {
                }
            }
        });
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread toFinish = toFinishIfWaitingTooMuch(10000);
                toFinish.start();
                Thread.sleep(delta);
                afficheur.afficher(name, queue.take());
                toFinish.interrupt();

            } catch (InterruptedException ex) {
                System.out.println("Fin du consommateur " + name);
                return;
            }
        }
    }
}

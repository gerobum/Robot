/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.illustrationDuCours;

import demo.Afficheur;
import demo.Consumer;
import demo.Producer;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author maillot
 */
public class Main {

    public static void main(String[] args) {
        LinkedBlockingDeque<Double> lbd = new LinkedBlockingDeque<>(2);

        Producer p = new Producer(lbd, "P1", 0, 20, false);
        Consumer c = new Consumer(lbd, "C1", 100, new Afficheur() {
            @Override
            public void afficher(String name, double v) {
                System.out.println(name + " : " + v);
            }
        });

        p.start();
        c.start();
        System.out.println("FIN DU MAIN");
  
    }
}

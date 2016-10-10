/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author maillot
 */
public class Main {

    
    public static void main(String[] args) {
        // Pour voir, changez 
        //   - les intervalles entre productions et entre consommations
        //   - le nombre de consommateur et de producteurs pour voir.
        //   - la capacité de la file bloquante...
        
        LinkedBlockingDeque<Double> lbd = new LinkedBlockingDeque<>(10);

        Producer p1 = new Producer(lbd, "P1", 0, 5000, false);
        Consumer c1 = new Consumer(lbd, "C1", 10, afficheur);
        Consumer c2 = new Consumer(lbd, "C2", 100, afficheur);

        c1.start();
        c2.start();
        p1.start();

    }
    // et 
    private static Afficheur afficheur = new Afficheur() {
        StringBuilder sb = new StringBuilder("|");

        private String doubleToString(double d) {
            if (d >= 1.0) {
                return d + "";
            } else {
                for (int i = 0; i < Math.round(d * 100); ++i) {
                    sb.append('=');
                }
            }
            return sb.toString();
        }

        @Override
        public void afficher(String name, double v) {
            System.out.println(name + " : " + doubleToString(v));
        }
    };
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maillot
 */
public class SlowRWMain {
    private static ReadWriteMap<String, Integer> rwm = new ReadWriteMap<>();
    private static final Random RANDOM = new Random();
    private static final int DIM = 26;
    
    /**
     * Utilisation de slowPutAvecVerrousRW 
     */
    public static void lanceEcrivain(final int n) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    
                    int k = RANDOM.nextInt(DIM);
                    rwm.slowPutAvecVerrousRW("Code de " + 'A'+k, k);
                    System.out.println("E"+n + " : a écrit");
                }
            }
        }).start();        
    }
        
    /**
     * Utilisation de slowPutAvecVerrousRW 
     */
    public static void lanceLecteur(final int n) {


        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    
                    int k = RANDOM.nextInt(DIM);
                    Integer lu = rwm.slowGetAvecVerrousRW("Code de " + 'A'+k);
                    System.out.print("L"+n+"("+lu+") ");
                }
            }
        }).start();       
    }
    
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int ne, nl;
        System.out.print("Combien de lecteurs : ");
        nl = clavier.nextInt();
        System.out.print("Combien d'écrivains : ");
        ne = clavier.nextInt();
        
        for(int i = 1; i <= nl; i++) {
            lanceLecteur(i);
        }
        
        for(int i = 1; i <= ne; i++) {
            lanceEcrivain(i);
        }
    }
}

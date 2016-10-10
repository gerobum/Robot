/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lock;

import java.util.Random;

/**
 *
 * @author maillot
 */
public class Amiti� extends Thread {

    private static final Random random = new Random();
    private final Ami a, b;

    public Amiti�(Ami a, Ami b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(10));
                a.estSalu�Par(b);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        final Ami pierre = new Ami("Pierre");
        final Ami serge = new Ami("Serge");
        new Amiti�(pierre, serge).start();
        new Amiti�(serge, pierre).start();
    }
}

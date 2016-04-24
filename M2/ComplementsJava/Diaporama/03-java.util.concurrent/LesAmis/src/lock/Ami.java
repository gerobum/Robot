/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author maillot
 */
public class Ami {

    public final String nom;
    private int num = 0;
    public ReentrantLock verrou = new ReentrantLock();

    public Ami(String nom) {
        this.nom = nom;
    }

    public void estSaluéPar(Ami ami) {
        boolean monVerrou = false;
        boolean tonVerrou = false;
        try {
            monVerrou = verrou.tryLock();
            tonVerrou = ami.verrou.tryLock();
            if (monVerrou && tonVerrou) { // Les deux verrous étaient libres, on peut y aller
                System.out.println(ami.nom + " salue " + nom + " (" + num++ + ")");
                ami.estSaluéEnRetourPar(this);
            }
        } finally {
            if (monVerrou) {
                verrou.unlock();
            }
            if (tonVerrou) {
                ami.verrou.unlock();
            }
        }
    }

    public void estSaluéEnRetourPar(Ami ami) {
        verrou.lock();
        try {
            System.out.println(ami.nom + " répond a " + nom);
        } finally {
            verrou.unlock();
        }
    }

}

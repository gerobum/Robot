/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lettres;

import demo.ReadWriteMap;
import java.util.Random;

/**
 *
 * @author maillot
 */
public class Course {

  private final ReadWriteMap<String, Integer> rwm = new ReadWriteMap<>();
  private final ReadWriteMap<String, Integer> syncm = new ReadWriteMap<>();
  private final Random RANDOM = new Random();
  private final int DIM = 26;

  private class EcrivainRW extends Thread {

    @Override
    public void run() {
      while (!rwm.remplie(26)) {
        int k = RANDOM.nextInt(DIM);
        rwm.slowPutAvecVerrousRW("Code de " + 'A' + k, k);
        System.out.println("ERW a écrit " + k);
      }
      System.out.println("RW a terminé");
    }
  }

  private class LecteurRW extends Thread {

    private final int numero;

    public LecteurRW(int n) {
      numero = n;
    }

    @Override
    public void run() {
      Integer lu = null;
      while (!rwm.remplie(26)) {
        int k = RANDOM.nextInt(DIM);
        lu = rwm.slowGetSynchro("Code de " + 'A' + k);
        System.out.print("LRW" + numero + "(" + lu + ") ");
      }
    }
  }

  private class EcrivainSync extends Thread {

    @Override
    public void run() {
      while (!syncm.remplie(26)) {
        int k = RANDOM.nextInt(DIM);
        syncm.slowPutSynchro("Code de " + 'A' + k, k);
        System.out.println("ESync a écrit " + k);
      }
      System.out.println("Sync a terminé");
    }
  }

  private class LecteurSync extends Thread {

    private final int numero;

    public LecteurSync(int n) {
      numero = n;
    }

    @Override
    public void run() {
      Integer lu = null;
      while (!syncm.remplie(26)) {
        int k = RANDOM.nextInt(DIM);
        lu = syncm.slowGetSynchro("Code de " + 'A' + k);
        System.out.print("LSync" + numero + "(" + lu + ") ");
      }
    }
  }
  
  public Course() {
    for (int i = 0; i < 26; i++) {
      new LecteurRW(i).start();
      new LecteurSync(i).start();
    }
    new EcrivainRW().start();
    new EcrivainSync().start();
  }

  public static void main(String[] args) {

    new Course();
    //lanceEcrivain(1);
  }

}

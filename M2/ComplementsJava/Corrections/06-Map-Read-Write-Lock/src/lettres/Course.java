/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lettres;

import exo.ReadWriteMap;
import exo.SynchronizedMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author maillot
 */
public class Course {

  private final Map<Character, Integer> rwm = new ReadWriteMap<>(2);
  private final Map<Character, Integer> syncm = new SynchronizedMap<>(2);
  private final Random RANDOM = new Random();
  private final int DIM = 26;
  private static long depart;

  private class EcrivainRW extends Thread {

    @Override
    public void run() {
      while (rwm.size() < 26) {
        int k = RANDOM.nextInt(DIM);
        rwm.put((char)('A'+k), k);
      }
      long duree = System.currentTimeMillis() - depart;
      System.err.println("RW   a terminé après " + (duree/1000) + " sec et " + (duree%1000) + " ms" );
    }
  }

  private class LecteurRW extends Thread {

    private final int numero;

    public LecteurRW(int n) {
      numero = n;
    }

    @Override
    public void run() {
      Integer lu;
      while (rwm.size() < 26) {
        int k = RANDOM.nextInt(DIM);
        lu = rwm.get((char)('A'+k));
      }
    }
  }

  private class EcrivainSync extends Thread {

    @Override
    public void run() {
      while (syncm.size() < 26) {
        int k = RANDOM.nextInt(DIM);
        syncm.put((char)('A'+k), k);
      }
      long duree = System.currentTimeMillis() - depart;
      System.err.println("Sync a terminé après " + (duree/1000) + " sec et " + (duree%1000) + " ms" );
    }
  }

  private class LecteurSync extends Thread {

    private final int numero;

    public LecteurSync(int n) {
      numero = n;
    }

    @Override
    public void run() {
      while (syncm.size() < 26) {
        int k = RANDOM.nextInt(DIM);
        syncm.get((char)('A'+k));
      }
    }
  }
  
  public Course() {
    for (int i = 0; i < 26; i++) {
      new LecteurSync(i).start();
      new LecteurRW(i).start();
    }
    new EcrivainSync().start();
    new EcrivainRW().start();
  }

  public static void main(String[] args) {
    depart = System.currentTimeMillis();
    new Course();
  }

}

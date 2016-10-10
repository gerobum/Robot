package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Objectifs : Utilisation de verrous (Lock) réentrants pour protéger une table
 * à accès direct.
 * <br>
 * Sujet : Par composition avec une implémentation de l'interface java.util.Map
 * développer une classe ReadWriteMap qui permettra à plusieurs threads
 * d'effectuer des recherches concurrentes dans cette map mais à un seul thread
 * de pouvoir y faire une insertion.
 * <br>
 * Aide : Munir votre classe d'attributs d'instance du type
 * java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock et
 * java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock pour garder
 * respectivement les recherches et les insertions.
 * <br>
 *
 * Consulter la Javadoc du paquetage java.util.concurrent.locks.
 * 
* <br>
 * <br>
 * Dans cette correction, quatre méthodes ont été rajoutées pour démonstration.
 * Elles simulent des accès long (1 seconde par défaut).
 * <br>
 * <ul>
 * <li>slowGetAvecVerrousRW</li> simule une lecture longue verrouillée par des
 * verrous RW.
 * <li>slowPutAvecVerrousRW</li> simule une écriture longue verrouillée par des
 * verrous RW.
 * <li>slowGetSynchro</li> simule une lecture longue dans une méthode
 * synchronisée.
 * <li>slowPutSynchro</li> simule une écriture longue dans une méthode
 * synchronisée.
 * </ul>
 * <br>
 * Les deux classes FastMain et SlowMain montrent comment le choix de
 * lectures/écritures protégées par des verrous RW peut s'avérer efficaces par
 * rapport à des lectures/écritures dans des méthodes synchronisées, dans le cas
 * de lecteurs multiples.
 */
public class ReadWriteMap<K, V> {

  private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  private final ReentrantReadWriteLock.ReadLock r = rwl.readLock();
  private final ReentrantReadWriteLock.WriteLock w = rwl.writeLock();
  private final Map<K, V> map = new HashMap<>();
  private final int DELAY = 1000;

  /**
   * Un get synchronisé autorisant les lectures multiples
   *
   * @param k
   * @return
   */
  public V get(K k) {
    r.lock();
    try {
      return map.get(k);
    } finally {
      r.unlock();
    }
  }

  /**
   * Un put synchronisé autorisant les lectures multiples
   *
   * @param k
   * @return
   */
  public V put(K k, V v) {
    w.lock();
    try {
      return map.put(k, v);
    } finally {
      w.unlock();
    }
  }

  // La suite n'existe que pour les tests
  public boolean remplie(int n) {
      r.lock();
    try {
      return map.size()==n;
    } finally {
      r.unlock();
    }  
  }
  
  public V slowGetAvecVerrousRW(K o) {

    r.lock();
    try {
      // Pour simuler une lecture longue
      Thread.sleep(DELAY);
      return map.get(o);
    } catch (InterruptedException ex) {
      return null;
    } finally {
      r.unlock();
    }
  }

  public V slowPutAvecVerrousRW(K key, V value) {

    w.lock();
    try {
      // Pour simuler une écriture longue
      Thread.sleep(DELAY);
      return map.put(key, value);
    } catch (InterruptedException ex) {
      return null;
    } finally {
      w.unlock();
    }
  }

  public synchronized V getSynchro(K o) {
    return map.get(o);
  }

  public synchronized V putSynchro(K key, V value) {
    return map.put(key, value);
  }

  public synchronized V slowGetSynchro(K o) {
    try {
      Thread.sleep(DELAY);
      return map.get(o);
    } catch (InterruptedException ex) {
      return null;
    }
  }

  public synchronized V slowPutSynchro(K key, V value) {
    try {
      Thread.sleep(DELAY);
      return map.put(key, value);
    } catch (InterruptedException ex) {
      return null;
    }
  }
}

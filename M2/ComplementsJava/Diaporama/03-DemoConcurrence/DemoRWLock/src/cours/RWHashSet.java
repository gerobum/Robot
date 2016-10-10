/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author yvan
 */
public class RWHashSet<E> {
  private final List<E> l = new ArrayList<>();
  private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
  private final Lock r = rwl.readLock();
  private final Lock w = rwl.writeLock();

  public E get(int i) {
    r.lock(); // Bloque l’écriture
    try {
      return l.get(i);
    } finally {
      r.unlock();
    }
  }
  public E set(int i, E e) {
    w.lock(); // Bloque les deux
    try {
      return l.set(i, e);
    } finally {
      w.unlock();
    }
  }
}

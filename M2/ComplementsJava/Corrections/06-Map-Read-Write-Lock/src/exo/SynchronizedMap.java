package exo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import static java.lang.Thread.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
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
 * <br>
 * Dans cette correction, quatre méthodes ont été rajoutées pour démonstration.
 * Elles simulent des accès long (1 seconde par défaut).
 * <br>
 * Les deux classes FastMain et SlowMain montrent comment le choix de
 * lectures/écritures protégées par des verrous RW peut s'avérer efficaces par
 * rapport à des lectures/écritures dans des méthodes synchronisées, dans le cas
 * de lecteurs multiples.
 */
public class SynchronizedMap<K, V> implements Map<K, V> {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock r = rwl.readLock();
    private final ReentrantReadWriteLock.WriteLock w = rwl.writeLock();
    private final Map<K, V> map;
    // Ce délais n'existe que pour les tests.
    private final int DELAY;

    public SynchronizedMap(int delay) {
        map = new HashMap<>();
        DELAY = delay;
    }

    public SynchronizedMap() {
        this(0);
    }

    public SynchronizedMap(Map<? extends K, V> m, int delay) {
        map = new HashMap<>(m);
        DELAY = delay;
    }

    public SynchronizedMap(Map<? extends K, V> m) {
        this(m, 0);
    }

    public SynchronizedMap(int initialCapacity, int delay) {
        map = new HashMap<>(initialCapacity);
        DELAY = delay;
    }

    public SynchronizedMap(int initialCapacity, float loadFactor, int delay) {
        map = new HashMap<>(initialCapacity, loadFactor);
        DELAY = delay;
    }

    /*
     * Un get synchronisé autorisant les lectures multiples
     * Le delais n'existe que pour simuler une lecture longue
     */
    @Override
    public synchronized V get(Object k) {
        try {
            if (DELAY > 0) sleep(DELAY);
            return map.get(k);
        } catch (InterruptedException ex) {
            return null;
        }
    }

    /*
     * Un put synchronisé autorisant les lectures multiples
     * Le delais n'existe que pour simuler une écriture longue
     */
    @Override
    public synchronized V put(K k, V v) {
        try {
            if (DELAY > 0) sleep(DELAY);
            return map.put(k, v);
        } catch (InterruptedException ex) {
            return null;
        }
    }

    @Override
    public synchronized int size() {
        return map.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public synchronized boolean containsValue(Object value) {

        return map.containsValue(value);

    }

    @Override
    public synchronized V remove(Object key) {

        return map.remove(key);

    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {

        map.putAll(m);

    }

    @Override
    public synchronized void clear() {

        map.clear();

    }

    @Override
    public synchronized Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public synchronized Collection<V> values() {
        return map.values();
    }

    @Override
    public synchronized Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}

package exo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import static java.lang.Thread.*;

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
 *
 * 
 * 
 */
public class ReadWriteMap<K, V> implements Map<K, V> {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock r = rwl.readLock();
    private final ReentrantReadWriteLock.WriteLock w = rwl.writeLock();
    private final Map<K, V> map;
    // Ce délais n'existe que pour les tests.
    private final int DELAY;
    
    public ReadWriteMap(int delay) {
        map = new HashMap<>();
        DELAY = delay;
    }
    
    public ReadWriteMap() {
        this(0);
    }
    
    public ReadWriteMap(Map<? extends K, V> m, int delay) {
        map = new HashMap<>(m);
        DELAY = delay;
    }
    
    public ReadWriteMap(Map<? extends K, V> m) {
        this(m, 0);
    }
    
    public ReadWriteMap(int initialCapacity, int delay) {
        map = new HashMap<>(initialCapacity);
        DELAY = delay;
    }
    
    public ReadWriteMap(int initialCapacity, float loadFactor, int delay) {
        map = new HashMap<>(initialCapacity, loadFactor);
        DELAY = delay;
    }
    
    /*
     * Un get synchronisé autorisant les lectures multiples
     * Le delais n'existe que pour simuler une lecture longue
     */
    @Override
    public V get(Object k) {
        r.lock();
        try {
            if (DELAY>0) sleep(DELAY);
            return map.get(k);
        } catch (InterruptedException ex) {
            return null;
        } finally {
            r.unlock();
        }
    }

    /*
     * Un put synchronisé autorisant les lectures multiples
     * Le delais n'existe que pour simuler une écriture longue
     */
    @Override
    public V put(K k, V v) {
        w.lock();
        try {
            if (DELAY>0) sleep(DELAY);
            return map.put(k, v);
        } catch (InterruptedException ex) {
            return null;
        } finally {
            w.unlock();
        }
    }


    @Override
    public int size() {
        r.lock();
        try {
            return map.size();
        } finally {
            r.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        r.lock();
        try {
            return map.isEmpty();
        } finally {
            r.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        r.lock();
        try {
            return map.containsKey(key);
        } finally {
            r.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        r.lock();
        try {
            return map.containsValue(value);
        } finally {
            r.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        w.lock();
        try {
            return map.remove(key);
        } finally {
            w.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        w.lock();
        try {
            map.putAll(m);
        } finally {
            w.unlock();
        }
    }

    @Override
    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    @Override
    public Set<K> keySet() {
        r.lock();
        try {
            return map.keySet();
        } finally {
            r.unlock();
        }
    }

    @Override
    public Collection<V> values() {
        r.lock();
        try {
            return map.values();
        } finally {
            r.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        r.lock();
        try {
            return map.entrySet();
        } finally {
            r.unlock();
        }
    }
}

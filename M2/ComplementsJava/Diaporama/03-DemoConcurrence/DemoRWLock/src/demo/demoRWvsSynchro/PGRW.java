
package demo.demoRWvsSynchro;


import java.util.concurrent.locks.ReentrantReadWriteLock;


public class PGRW implements PG {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock r = rwl.readLock();
    private final ReentrantReadWriteLock.WriteLock w = rwl.writeLock();

    private final int DELAY = 1000;

 
    @Override
    public void get() {
        r.lock();
        try {
            // Pour simuler une lecture longue
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
        } finally {
            r.unlock();
        }
    }

    @Override
    public void put() {
        w.lock();
        try {
            // Pour simuler une écriture longue
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
        } finally {
            w.unlock();
        }
    }
}

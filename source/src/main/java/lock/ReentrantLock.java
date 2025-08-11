package lock;

import lombok.extern.slf4j.Slf4j;

/**
 * ReentrantLock
 *
 * @author relsola
 */
@Slf4j
public class ReentrantLock {
    private volatile int state = 0;

    private Thread owner = null;

    private int count = 0;

    public synchronized void lock() {
        Thread current = Thread.currentThread();
        if (owner == current) {
            count++;
            return;
        }

        while (state == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        state = 1;
        owner = current;
        count = 1;
    }

    public synchronized void unlock() {
        Thread current = Thread.currentThread();
        if (owner == current) {
            count--;
            if (count == 0) {
                owner = null;
                state = 0;
                this.notifyAll();
            }
        }
    }
}

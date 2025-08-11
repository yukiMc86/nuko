import lock.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * ReentrantLockTest
 *
 * @author relsola
 */
@Slf4j
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();
            try {
                log.info("{} => 1", Thread.currentThread().getName());
                lock.lock();
                try {
                    log.info("{} => 2", Thread.currentThread().getName());
                } finally {
                    lock.unlock();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            } finally {
                lock.unlock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}

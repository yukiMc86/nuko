package ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor
 *
 * @author relsola
 */

@Slf4j
public class ThreadPoolExecutor {
    private final HashSet<Worker> workers = new HashSet<>();

    private final BlockingQueue<Runnable> taskQueue;

    private final RejectPolicy<Runnable> rejectPolicy;

    private final int coreSize;

    private final long timeout;

    private final TimeUnit timeUnit;

    public ThreadPoolExecutor(
            int coreSize,
            long Timeout,
            TimeUnit TimeUnit,
            int queueSize,
            RejectPolicy<Runnable> rejectPolicy
    ) {
        this.coreSize = coreSize;
        this.timeout = Timeout;
        this.timeUnit = TimeUnit;
        this.taskQueue = new BlockingQueue<Runnable>(queueSize);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else {
                // 拒绝策略
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread {
        private Runnable task;

        Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    log.error(e.getMessage());
                } finally {
                    task = null;
                }
            }

            synchronized (workers) {
                workers.remove(this);
            }
        }
    }
}

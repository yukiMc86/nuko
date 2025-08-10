import ThreadPoolExecutor.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutorTest
 *
 * @author relsola
 */
@Slf4j
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                1000,
                TimeUnit.MILLISECONDS,
                10,
                (queue, task) -> {
                    //1、死等
                    queue.put(task);
                    //2、带超时等待
                    // queue.offer(task,1500, TimeUnit.NANOSECONDS);
                    //3、放弃任务执行
                    // log.debug("放弃{}",task);
                    //4、抛出异常
                    // throw new RuntimeException("任务执行失败"+task);
                    //5、让调用者自己执行任务
                    // task.run();
                }
        );

        for (int i = 0; i < 15; i++) {
            final int cur = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                log.info("{}", cur);
            });
        }

        log.info("<--------------- Main --------------->");
    }
}

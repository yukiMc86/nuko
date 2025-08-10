package ThreadPoolExecutor;

/**
 * RejectPolicy
 *
 * @author relsola
 */
@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}

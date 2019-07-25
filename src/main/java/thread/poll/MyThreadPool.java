package thread.poll;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haishen
 * @date 2019/03/01
 */
public class MyThreadPool {

    /**
     * 核心线程数
     */
    public static int CORE_POOL_SIZE = 10;

    /**
     * 最大线程线程数
     */
    public static int MAX_POOL_SIZE = 15;

    /**
     * 空闲时线程退出时间:1秒
     */
    public static long KEEP_ALIVE_TIME = 3L;

    private volatile static ExecutorService executorService;

    public MyThreadPool() {
        if (executorService == null) {
            synchronized (MyThreadPool.class) {
                if (executorService == null) {
                    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(CORE_POOL_SIZE);
                    executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                            workQueue, new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
    }

    /**
     * 获取线程池
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    static class MyThreadFactory implements ThreadFactory {

        private AtomicInteger id = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("thread-pool-test-" + id.addAndGet(1));
            return thread;
        }
    }

}

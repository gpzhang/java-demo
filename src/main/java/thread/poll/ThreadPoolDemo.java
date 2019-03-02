package thread.poll;

import java.util.concurrent.ExecutorService;

/**
 * @author haishen
 * @date 2019/3/1
 */
public class ThreadPoolDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        FixedThreadPool fixedThreadPool = new FixedThreadPool();
        ExecutorService executorService = fixedThreadPool.getExecutorService();
        System.out.println("获取ExecutorService:" + executorService);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "1开始执行！");
                try {
                    Thread.sleep(10 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "1结束执行！");
            }
        });
    }
}

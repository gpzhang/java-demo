package thread.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haishen
 * @date 2019/3/1
 */
public class ThreadPoolDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("COUNT_BITS   :Integer.SIZE - 3     --->" + Integer.toBinaryString(COUNT_BITS));
        System.out.println("CAPACITY     :(1 << COUNT_BITS) - 1--->000" + Integer.toBinaryString(CAPACITY));
        System.out.println("RUNNING      :-1 << COUNT_BITS     --->" + Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN     : 0 << COUNT_BITS     --->" + Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP         : 1 << COUNT_BITS     --->00" + Integer.toBinaryString(STOP));
        System.out.println("TIDYING      : 2 << COUNT_BITS     --->0" + Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED   : 3 << COUNT_BITS     --->0" + Integer.toBinaryString(TERMINATED));

        FixedThreadPool fixedThreadPool = new FixedThreadPool();
        ExecutorService executorService = fixedThreadPool.getExecutorService();
        System.out.println("获取ExecutorService:" + executorService);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "1开始执行！");
                try {
                    Thread.sleep(20 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "1结束执行！");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "2开始执行！");
                try {
                    Thread.sleep(10 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "2结束执行！");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "3开始执行！");
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "3结束执行！");
            }
        });
        executorService.shutdown();
    }
}

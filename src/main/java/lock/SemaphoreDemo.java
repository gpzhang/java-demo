package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2019/7/8
 * <p>
 * Semaphore可以理解为信号量，用于控制资源能够被并发访问的线程数量，
 * 以保证多个线程能够合理的使用特定资源。Semaphore就相当于一个许可证，
 * 线程需要先通过acquire方法获取该许可证，该线程才能继续往下执行，
 * 否则只能在该方法出阻塞等待。当执行完业务功能后，
 * 需要通过release()方法将许可证归还，以便其他线程能够获得许可证继续执行。
 */
public class SemaphoreDemo {

    /**
     * 表示许可证个数
     */
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(new Thread(new Worker()));
        }
        service.shutdown();
    }

    private static class Worker implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "  同学获取到笔，填写表格ing.....");
                TimeUnit.SECONDS.sleep(3);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

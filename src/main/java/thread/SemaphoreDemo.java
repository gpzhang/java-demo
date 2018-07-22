package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2018/7/22
 */
public class SemaphoreDemo {

    //表示老师只有10支笔
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        //表示50个学生
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "  01同学准备获取笔......");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  02同学获取到笔");
                    System.out.println(Thread.currentThread().getName() + "  02填写表格ing.....");
                    TimeUnit.SECONDS.sleep(30);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "  03填写完表格，归还了笔！！！！！！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }

}

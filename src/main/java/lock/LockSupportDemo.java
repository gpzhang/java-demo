package lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author haishen
 * @date 2019/3/8
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "即将被阻塞!!!");
            Long begin = System.currentTimeMillis();
            LockSupport.park();
            Long end = System.currentTimeMillis();
            System.out.println((end - begin) / 1000 + "秒后[" + Thread.currentThread().getName() + "]被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }

}

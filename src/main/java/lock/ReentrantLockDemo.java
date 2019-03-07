package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haishen
 * @date 2018/7/15
 * <p>
 * 可重入锁的公平性和不公平性体现在
 * 当前线程获取锁时
 * 不公平状态下：当前线上如果能够获取锁，则不用放入等待队列，直接获取锁成功
 * 公平状态下：当前线上要判断是否有比其更早请求线程正在队列里，如果有则如入等待对垒；如果没有才不用放入等待队列，直接获取锁成功
 */
public class ReentrantLockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}

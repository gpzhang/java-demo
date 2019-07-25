package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haishen
 * @date 2018/7/15
 * ReentrantLock的特性
 * 1、支持可重入
 * 2、支持公平锁和非公平锁
 * <p>
 * 可重入锁的公平性和不公平性体现在
 * 当前线程获取锁时
 * 不公平状态下：当前线上如果能够获取锁，则不用放入等待队列，直接获取锁成功
 * 公平状态下：当前线上要判断是否有比其更早请求线程正在队列里，如果有则如入等待对垒；如果没有才不用放入等待队列，直接获取锁成功
 * <p>
 * 非公平锁和公平锁的不同在于获取锁状态时增加了hasQueuedPredecessors的逻辑判断（当前节点是否存在前驱节点）
 */
public class ReentrantLockDemo {
    /**
     * 默认非公平锁
     */
    private static ReentrantLock defaultUnfairLock = new ReentrantLock();

    /**
     * 创建公平锁
     */
    private static ReentrantLock fairLock = new ReentrantLock(true);

    /**
     * 显式创建非公平锁
     */
    private static ReentrantLock unfairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        acquire();
        acquireInterrputibly();
        tryAcquireNanos();

    }

    /**
     * 独占锁的获取和释放demo
     */
    private static void acquire() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                defaultUnfairLock.lock();
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    defaultUnfairLock.unlock();
                }
            });
            thread.start();
        }
    }

    /**
     * 可中断式锁的获取和释放demo
     * 该实现锁会响应中断,响应的方式是获取锁的过程中判断当前线程是否中断了
     * 如果线程被设置为中断，则直接抛线程中断异常
     */
    private static void acquireInterrputibly() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    defaultUnfairLock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    defaultUnfairLock.unlock();
                }
            });
            thread.start();
        }
    }

    /**
     * 超时等待式获取锁和释放demo
     * 在响应线程中断的基础上又增加了获取锁超时限制
     */
    private static void tryAcquireNanos() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    defaultUnfairLock.tryLock(3 * 1000, TimeUnit.MICROSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    defaultUnfairLock.unlock();
                }
            });
            thread.start();
        }
    }


}

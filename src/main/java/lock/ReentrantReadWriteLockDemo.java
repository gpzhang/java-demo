package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author haishen
 * @date 2019/6/12
 */
public class ReentrantReadWriteLockDemo {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        readLock();
        writeLock();
    }

    /**
     * 写锁的获取和释放demo（共享锁）
     */
    private static void readLock() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.readLock().lock();
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.readLock().unlock();
                }
            });
            thread.start();
        }
    }

    /**
     * 写锁的获取和释放demo（独占锁）
     */
    private static void writeLock() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.writeLock().lock();
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
                }
            });
            thread.start();
        }
    }

}

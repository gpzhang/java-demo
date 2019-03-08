package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haishen
 * @date 2019/3/8
 */
public class ConditionDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;


    public static void main(String[] args) {
        Thread waiter01 = new Thread(new Waiter01());
        waiter01.start();
        Thread waiter02 = new Thread(new Waiter02());
        waiter02.start();
        Thread signaler = new Thread(new Signaler());
        signaler.start();

    }

    static class Waiter01 implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("线程:[" + Thread.currentThread().getName() + "]获得了锁");
            try {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + "当前条件不满足进入等待");
                    try {
                        System.out.println("线程:[" + Thread.currentThread().getName() + "]准备释放锁");
                        condition.await();
                        System.out.println("线程:[" + Thread.currentThread().getName() + "]重新获得了锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "接收到通知条件满足");
            } finally {
                lock.unlock();

            }
        }
    }

    static class Waiter02 implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("线程:[" + Thread.currentThread().getName() + "]获得了锁");
            try {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + "当前条件不满足进入等待");
                    try {
                        System.out.println("线程:[" + Thread.currentThread().getName() + "]开始准备释放锁");
                        condition.await();
                        System.out.println("线程:[" + Thread.currentThread().getName() + "]已经重新获得了锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "接收到通知条件满足");
            } finally {
                lock.unlock();
            }
        }
    }

    static class Signaler implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("线程:[" + Thread.currentThread().getName() + "]获得了锁");
            try {
                flag = true;
                condition.signalAll();
                System.out.println("线程:[" + Thread.currentThread().getName() + "]释放了锁,并通知到其他线程");
            } finally {
                lock.unlock();
            }
        }
    }

}

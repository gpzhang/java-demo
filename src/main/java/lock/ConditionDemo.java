package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haishen
 * @date 2019/3/8
 * Condition与Lock配合完成等待通知机制，是java语言级别的，具有更高的可控制性和扩展性;
 * 创建一个Condition对象是通过lock.newCondition(),而这个方法实际上是会new出一个ConditionObject对象。
 * <p>
 * 因为Condition是配合锁lock使用的,线程在获取锁后需要进行等待或者通知时，实际就作出是否让出锁的操作，所有由锁对象执行方法（newCondition()）创建Condition对象就显得很合理；
 * <p>
 * condition内部维护了一个 等待队列，所有调用condition.await方法的线程会加入到等待队列中，并且线程状态转换为等待状态。
 * <p>
 * 当前线程执行condition.await()方法时，因为已经获取锁了，所以已经从AQS的等待队列中移除，同时当前线程将会加入ConditionObject对象的等待队列中；
 * 直到有线程执行了condition.signal()/condition.signalAll()方法，在方法内部逻辑中会重新将将要唤醒的线程加入到AQS节点链表中的尾节点；然后执行线程唤醒操作；
 * 被唤醒的等待线程会继续执行condition.await()方法剩下的逻辑，
 * 首先就是调用acquireQueued方法决定是否将被唤醒的节点在AQS的等待队列中是否需要阻塞已经等待最后AQS的唤醒。
 * <p>
 * 移除再添加
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
                condition.signalAll();//轮询唤醒所有等待线程
                condition.signal();//唤醒某一个等待线程，其他的等待线程还是处于等待中，需要被另外通知。
                System.out.println("线程:[" + Thread.currentThread().getName() + "]释放了锁,并通知到其他线程");
            } finally {
                lock.unlock();
            }
        }
    }

}

package lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author haishen
 * @date 2019/3/8
 * <p>
 * 有一点需要需要的是：synchronzed致使线程阻塞，线程会进入到BLOCKED状态；
 * *** BLOCKED状态: 阻塞状态是线程阻塞在进入synchronized关键字修饰的方法或代码块(获取锁)时的状态。
 * 而调用LockSupport方法阻塞线程会致使线程进入到WAITING状态。
 * *** WAITING状态: 处于这种状态的线程不会被分配CPU执行时间，它们要等待被显式地唤醒，否则会处于无限期等待的状态。
 * <p>
 * thread线程调用LockSupport.park()致使thread阻塞,
 * 当main线程睡眠3秒结束后通过LockSupport.unpark(thread)方法唤醒thread线程,
 * thread线程被唤醒执行后续操作。
 * 另外，还有一点值得关注的是,
 * LockSupport.unpark(thread)可以指定线程对象唤醒指定的线程。
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

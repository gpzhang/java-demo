package thread;

/**
 * @author haishen
 * @date 2018/7/2
 * 通常可以用如下方式避免死锁的情况：
 * <p>
 * 1、避免一个线程同时获得多个锁；
 * 2、避免一个线程在锁内部占有多个资源，尽量保证每个锁只占用一个资源；
 * 3、尝试使用定时锁，使用lock.tryLock(timeOut)，当超时等待时当前线程不会阻塞；
 * 4、对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况
 */
public class DeadLockDemo {
    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (resource_a) {
                    System.out.println("get resource a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b) {
                            System.out.println("get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resource_b) {
                    System.out.println("get resource b");
                    synchronized (resource_a) {
                        System.out.println("get resource a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
package thread;

/**
 * @author haishen
 * @date 2019/6/11
 * 线程中断的demo
 * <p>
 * Interrupt中断是线程的某一部分业务逻辑，而这部分业务逻辑需要线程去检查自己的中断状态（通过isInterrupted()）
 * 中断判断的两种方式
 * 1、Thread.currentThread().isInterrupted();实例方法，不会清除中断状态
 * 2、Thread.interrupted();类方法，会清除中断状态
 * <p>
 * 当线程被阻塞的时候（调用了阻塞方法），比如被Object.wait,Thread.sleep和 Thread.join()和三种方法之一阻塞时。
 * 顺便也说一下wait()方法和sleep()方法的区别
 * 1、在通过Synchronized关键字实现同步机制的逻辑内使用sleep()时，线程阻塞会让出CPU资源，但不会释放锁资源；wait()时线程阻塞会让出CPU资源，同时也会释放锁资源
 * 2、sleep()方法可以在任何方法中使用，而wait()方法只能在同步方法或同步代码块中使用；
 * 3、sleep()方法在阻塞指定时间后会恢复执行，而wait()方法
 * <p>
 * 因为线程阻塞，让出CPU资源，没有占用CPU运行的线程是不可能给自己的中断状态进行置位操作的，所以如果在线程阻塞的时候调用它的interrupt()方法。
 * 就会产生一个InterruptedException异常。
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyInterruptUnBlockThread());
        thread.start();
        thread.interrupt();

        System.out.println("执行了对线程:{" + thread.getName() + "}的中断操作！！！");

    }


    /**
     * 一个未阻塞线程响应中断的处理逻辑
     * 通过调用线程的isInterrupted()方法判断线程中断状态，做业务逻辑处理
     */
    static class MyInterruptUnBlockThread implements Runnable {

        @Override
        public void run() {
            while (true) {
//                if (Thread.interrupted()) {
//                    System.out.println("线程被设置中断，干点啥？");
//                }
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被设置中断，干点啥？");
                }
                long i = 0;
                do {
                    i++;
                } while (i < (Integer.MAX_VALUE));
                i = 0;
                System.out.println("当前线程疯狂执行中！！！");
            }
        }
    }

    /**
     * 一个阻塞线程响应中断的处理逻辑
     * 给当前阻塞线程一个中断操作的异常，从而让当前阻塞线程能够运行响应中断异常
     * 在中断异常的catch代码逻辑内输出当前线程的中断状态结果为false，
     * 中断状态并没有被改变，也说明设置线程中断的操作失败，只能抛异常了。
     */
    static class MyInterruptBlockThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    System.out.println("线程阻塞时，线程被设置中断，只能抛异常，catch后在自己看这办！！！  " + Thread.currentThread().isInterrupted());
                }
                System.out.println("当前线程疯狂执行中！！！" + Thread.currentThread().isInterrupted());
            }
        }
    }


}

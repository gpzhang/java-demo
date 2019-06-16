package thread;

import java.util.concurrent.*;

/**
 * 线程的状态：
 * 1. 初始状态
 * 实现Runnable接口和继承Thread可以得到一个线程类，new一个实例出来，线程就进入了初始状态。
 * <p>
 * 2. 就绪状态
 * 就绪状态只是说你资格运行，调度程序没有挑选到你，你就永远是就绪状态。
 * 调用线程的start()方法，此线程进入就绪状态。
 * 当前线程sleep()方法结束，其他线程join()结束，等待用户输入完毕，某个线程拿到对象锁，这些线程也将进入就绪状态。
 * 当前线程时间片用完了，调用当前线程的yield()方法，当前线程进入就绪状态。
 * 锁池里的线程拿到对象锁后，进入就绪状态。
 * <p>
 * 3. 阻塞状态
 * 阻塞状态是线程阻塞在进入synchronized关键字修饰的方法或代码块（获取锁）时的状态。
 * <p>
 * 4. 等待
 * 处于这种状态的线程不会被分配CPU执行时间，它们要等待被显式地唤醒，否则会处于无限期等待的状态。
 * <p>
 * 5. 超时等待
 * 处于这种状态的线程不会被分配CPU执行时间，不过无须无限期等待被其他线程显示地唤醒，在达到一定时间后它们会自动唤醒。
 * <p>
 * 6. 终止状态
 * 当线程的run()方法完成时，或者主线程的main()方法完成时，我们就认为它终止了。这个线程对象也许是活的，但是，它已经不是一个单独执行的线程。线程一旦终止了，就不能复生。
 * 在一个终止的线程上调用start()方法，会抛出java.lang.IllegalThreadStateException异常。
 * <p>
 * 参考：https://blog.csdn.net/pange1991/article/details/53860651
 * 这个说法是九种（对超时状态做了更细的区分）：https://blog.csdn.net/qq_37909508/article/details/89789189
 *
 * @author haishen
 * @date 2018/7/15
 */


public class CreateThread {
    public static void main(String[] args) {
        //1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("方式1,继承thread");
                super.run();
            }
        };
        thread.start();

        //2.实现runable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("方式2,实现Runable接口");
            }
        });
        thread1.start();

        //3.实现callable接口
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "方式3,实现callable接口";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

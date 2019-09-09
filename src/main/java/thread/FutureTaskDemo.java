package thread;

import java.util.concurrent.*;

/**
 * FutureTask是一种可以取消的异步的计算任务。
 * 它的计算是通过Callable实现的，可以把它理解为是可以返回结果的Runnable。
 * <p>
 * 使用FutureTask的优势有：
 * 可以获取线程执行后的返回结果；
 * 提供了超时控制功能。
 *
 * @author haishen
 * @date 2019/9/9
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(new MyTask());
        /**
         * 1、线程池的execute(Runnable command)方法没有返回值，
         * 2、Runnable实现类无返回值，
         * 3、Callable实现类需要封装成FutureTask，返回结果封装在FutureTask实现类中
         */
        executorService.execute(futureTask);
        System.out.println(Thread.currentThread().getName() + " continue doing!!!");
        System.out.println("execute(Runnable command)方法 结果" + futureTask.get());

        executorService.execute(new MyTaskTwo());

        /**
         * 线程池的submit(Runnable task)方法会返回Future实现类 泛型结果为Void
         */
        Future result = executorService.submit(new MyTaskTwo());
        System.out.println("submit(Runnable task) 结果:" + result.get());

        /**
         * 线程池的submit(Callable<T> task)方法会返回Future实现类 泛型结果为指定
         */
        Future future = executorService.submit(new MyTask());
        System.out.println("submit(Callable<T> task)方法 结果:" + future.get());

        executorService.shutdown();

    }


    static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            long time = 3 * 1000L;
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + " do Something，cost time:" + time + "毫秒");
            return "hello!";
        }
    }

    static class MyTaskTwo implements Runnable {

        @Override
        public void run() {
            long time = 5 * 1000L;
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " do Something，cost time:" + time + "毫秒");
        }
    }


}

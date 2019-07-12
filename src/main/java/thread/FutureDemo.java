package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author haishen
 * @date 2019/1/22
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        System.out.println(es.submit(new Task()));
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(es.submit(new MyTask()));
        }
        // 获取执行结果
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " thread runing...");
        }

    }


    static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " do Something!!!");
            return "hello!";
        }
    }
}

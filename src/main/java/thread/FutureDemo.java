package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author haishen
 * @date 2019/1/22
 * <p>
 * Callable、Future、FutureTask的区别与联系：
 * <p>
 * Callable和Future的区别：
 * Callable用于产生结果，
 * Future用于获取结果
 * <p>
 * FutureTask实现类Future接口，是Future的实。用于获取线程执行结果
 * FutureTask并且持有Callable的实现类，用于执行逻辑，产生结果
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(es.submit(new MyTask()));
        }
        boolean done = false;
        do {
            for (Future<String> f : results) {
                //判断任务是否全部执行完成，连续全部执行完成才算完成
                System.out.println("任务是否执行完成：" + f.isDone());
                if (f.isDone()) {
                    done = true;
                } else {
                    done = false;
                    break;
                }
            }
            Thread.sleep(1 * 1000L);
        } while (!done);

        // 获取执行结果
        for (Future<String> f : results) {
            System.out.println(f.get());
        }

        es.shutdown();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " do Something!!!");
            Thread.sleep(5 * 1000L);
            return Thread.currentThread().getName() + " return !";
        }
    }
}

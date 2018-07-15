package thread;

import java.util.concurrent.*;

/**
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

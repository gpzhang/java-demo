package lock;

import thread.poll.MyThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

/**
 * CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 * CyclicBarrier是多个线程互等，等大家都完成，再携手共进；
 * CyclicBarrier是可以复用的
 *
 * @author haishen
 * @date 2019/7/2
 * <p>
 * 栅栏 等待线程达到预设值就释放等待
 * 侧重一批一批的线程执行，可复用
 */
public class CyclicBarrierDemo {

    private static final String FORMAT = "yy-MM-dd HH:mm:ss";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int barrierNum = 3;
        int totalThread = barrierNum * 2;
        //栅栏，相当于跑道，一个线程对应一个跑道，
        CyclicBarrier cyclicBarrier = new CyclicBarrier(barrierNum);
        //添加工人,创建执行线程数组,小于栅栏数会一致等待到线程足够,超过栅栏数的线程放在下一批执行
        Worker[] workers = new Worker[totalThread];
        for (int i = 0; i < totalThread; i++) {
            workers[i] = new Worker("工作线程:" + i, cyclicBarrier);
        }

        MyThreadPool myThreadPool = new MyThreadPool();
        ExecutorService executorService = myThreadPool.getExecutorService();
        //提交到线程池,分配线程
        for (Worker worker : workers) {
            executorService.execute(worker);
        }
        executorService.shutdown();
    }

    private static class Worker extends Thread {
        private String workName;
        private CyclicBarrier cyclicBarrier;

        public Worker(String workName, CyclicBarrier cyclicBarrier) {
            this.workName = workName;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            doWork();
        }

        private void doWork() {
            System.out.println("Worker :[" + workName + " ] 进入等待状态 at " + getFormat(new Date()));
            try {
                cyclicBarrier.await();
                Thread.sleep(RANDOM.nextInt(6) * 1000 + 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Worker :[" + workName + " ] do work complete at " + getFormat(new Date()));

        }
    }

    public static String getFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        return sdf.format(date);
    }


}


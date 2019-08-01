package lock;

import thread.poll.MyThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * 一个阻塞当前线程知道所有线程都执行完成的简单demo
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * CountDownLatch强调一个线程等多个线程完成某件事情；
 * CountDownLatch是不能复用的
 *
 * @author haishen
 * @date 2019/7/2
 */
public class CountDownLatchDemo {

    private static final String FORMAT = "yy-MM-dd HH:mm:ss";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {

        int selfCompleteNum = 1;
        int allCompleteNum = 5;
        //倒计时
        CountDownLatch selfDownLatch = new CountDownLatch(selfCompleteNum);
        CountDownLatch countDownLatch = new CountDownLatch(allCompleteNum);
        //添加工人,创建执行线程数组
        Worker[] workers = new Worker[allCompleteNum];
        for (int i = 0; i < allCompleteNum; i++) {
            workers[i] = new Worker("工作线程:" + i, selfDownLatch, countDownLatch);
        }

        MyThreadPool myThreadPool = new MyThreadPool();
        ExecutorService executorService = myThreadPool.getExecutorService();
        //提交到线程池,分配线程
        for (Worker worker : workers) {
            executorService.execute(worker);
        }
        //开始工作
        selfDownLatch.countDown();
        //完成工作
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("均完成后的时间：" + getFormat(new Date()));
    }

    public static String getFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        return sdf.format(date);
    }

    private static class Worker extends Thread {
        private String workName;
        private CountDownLatch selfLatch;
        private CountDownLatch latch;

        public Worker(String workName, CountDownLatch selfLatch, CountDownLatch latch) {
            this.workName = workName;
            this.selfLatch = selfLatch;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Worker " + workName + " do work begin at " + getFormat(new Date()));
            doWork();
            System.out.println("Worker " + workName + " do work complete at " + getFormat(new Date()));
        }

        private void doWork() {
            try {
                selfLatch.await();
                Thread.sleep(RANDOM.nextInt(6) * 1000 + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("Worker " + workName + " CountDownLatch count " + latch.getCount());
            }
        }
    }
}

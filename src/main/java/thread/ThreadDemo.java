package thread;

import thread.poll.ThreadPoolDemo;

/**
 * @author haishen
 * @date 2019/7/11
 */
public class ThreadDemo {

    /**
     * 两个线程交替减2、减3
     */
    private static volatile int COUNT_BITS = 9;
    private static int two = 2;
    private static int three = 3;

    private static String ss = "dd";


    public static void main(String[] args) throws InterruptedException {


        //该线程每次减2
        Thread thread01 = new Thread(new WorkThread(two));
        thread01.start();
        //该线程每次减3
        Thread thread02 = new Thread(new WorkThread(three));
        thread02.start();


    }

    static class WorkThread implements Runnable {

        private int num;

        public WorkThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (true) {

                synchronized (ss) {
                    if (COUNT_BITS >= num) {
                        COUNT_BITS = COUNT_BITS - num;
                        System.out.println(Thread.currentThread().getName() + "拿走" + num + "个，还剩：" + COUNT_BITS);
                        ss.notify();
                        try {
                            ss.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "剩余" + COUNT_BITS + "个不够拿");
                        try {
                            ss.notify();
                            Thread.sleep(30000L);
                            ss.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

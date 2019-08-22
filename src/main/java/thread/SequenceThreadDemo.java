package thread;

/**
 * @author haishen
 * @date 2019/8/21
 * // 通过N个线程顺序循环打印从0至100，如给定N=3则输出：
 * //  thread0: 0
 * //  thread1: 1
 * //  thread2: 2
 * //  thread0: 3
 * //  thread1: 4
 * //  ...
 * //  注意线程号与输出顺序间的关系。
 */
public class SequenceThreadDemo {
    private static Object lock = new Object();

    private static volatile int current;


    public static void main(String[] args) throws InterruptedException {

        int threadNum = 4;
        int maxValue = 100;
        Worker[] workers = new Worker[threadNum];
        for (int i = 0; i < threadNum; i++) {
            Worker worker = new Worker(i, maxValue, threadNum);
            workers[i] = worker;
        }
        for (int j = 0; j < workers.length; j++) {
            new Thread(workers[j]).start();
        }
    }


    private static class Worker implements Runnable {

        private int threadId;
        private int maxValue;
        private int threadNum;


        public Worker(int threadId, int maxValue, int threadNum) {
            this.threadId = threadId;
            this.maxValue = maxValue;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    //当前要打印的值对最大值取余不等于当前线程id，说明不该当前线程执行
                    if (current % threadNum != threadId) {
                        if (current >= maxValue) {
                            lock.notifyAll();
                            break;
                        }
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (current>maxValue){
                        break;
                    }
                    System.out.println("thread" + threadId + ":" + current);
                    current++;
                    lock.notifyAll();
                }
            }


        }
    }


}

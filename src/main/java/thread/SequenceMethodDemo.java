package thread;

/**
 * @author haishen
 * @date 2019/8/21
 * 多个线程调用同一个对象的方法，方法的执行在线程的调用过程中是有顺序的
 */
public class SequenceMethodDemo {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();

    /**
     * 调用这个方法的线程必须先执行
     *
     * @param printFirst
     * @throws InterruptedException
     */
    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    /**
     * first方法执行完成之后，必须执行second方法
     *
     * @param printSecond
     * @throws InterruptedException
     */
    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    /**
     * second方法执行完成之后，必须执行third方法
     *
     * @param printThird
     * @throws InterruptedException
     */
    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnableA = new MyRunable("one");
        Runnable runnableB = new MyRunable("two");
        Runnable runnableC = new MyRunable("three");

        SequenceMethodDemo sequenceThreadDemo = new SequenceMethodDemo();
        new Thread(new TwoWorker(sequenceThreadDemo, runnableB)).start();
        new Thread(new OneWorker(sequenceThreadDemo, runnableA)).start();
        new Thread(new ThreeWorker(sequenceThreadDemo, runnableC)).start();

    }

    private static class MyRunable implements Runnable {
        String result = null;

        public MyRunable(String name) {
            this.result = name;
        }

        @Override
        public void run() {
            System.out.println(result);
        }
    }

    private static class OneWorker implements Runnable {

        private SequenceMethodDemo sequenceThreadDemo;
        private Runnable myRunable;

        public OneWorker(SequenceMethodDemo sequenceThreadDemo, Runnable myRunable) {
            this.sequenceThreadDemo = sequenceThreadDemo;
            this.myRunable = myRunable;
        }

        @Override
        public void run() {
            try {
                sequenceThreadDemo.first(myRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TwoWorker implements Runnable {

        private SequenceMethodDemo sequenceThreadDemo;
        private Runnable myRunable;

        public TwoWorker(SequenceMethodDemo sequenceThreadDemo, Runnable myRunable) {
            this.sequenceThreadDemo = sequenceThreadDemo;
            this.myRunable = myRunable;
        }

        @Override
        public void run() {
            try {
                sequenceThreadDemo.second(myRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreeWorker implements Runnable {

        private SequenceMethodDemo sequenceThreadDemo;
        private Runnable myRunable;

        public ThreeWorker(SequenceMethodDemo sequenceThreadDemo, Runnable myRunable) {
            this.sequenceThreadDemo = sequenceThreadDemo;
            this.myRunable = myRunable;
        }

        @Override
        public void run() {
            try {
                sequenceThreadDemo.third(myRunable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

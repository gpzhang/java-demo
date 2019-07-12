package thread;

/**
 * @author haishen
 * @date 2019/3/3
 * <p>
 * yield执行后线程进入就绪状态
 */
public class ThreadYieldDemo {
    public static void main(String[] args) {
        Thread yieldThread = new YieldThread();
        yieldThread.start();
        Thread commonThread = new CommonThread();
        commonThread.start();

    }

    static class YieldThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + " 让出CPU资源");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class CommonThread extends Thread {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "普通线程执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

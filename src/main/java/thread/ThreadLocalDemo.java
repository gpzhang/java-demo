package thread;

/**
 * @author haishen
 * @date 2018/7/17
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> i = new ThreadLocal<>();
    private static int k = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            if (i.get() == null) {
                i.set(10);
            }
            int value = i.get();
            i.set(value + 1);
            System.out.println("线程<" + Thread.currentThread().getName() + ">i值:" + i.get());
        }
    }
}

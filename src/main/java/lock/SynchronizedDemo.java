package lock;

/**
 * @author haishen
 * @date 2018/7/15
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private synchronized static void method() {
    }
}

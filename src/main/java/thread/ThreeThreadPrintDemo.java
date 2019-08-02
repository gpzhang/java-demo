package thread;

/**
 * @author haishen
 * @date 2019/8/2
 * <p>
 * 三线程依次循环打印ABC
 */
public class ThreeThreadPrintDemo {

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        PrinterThread ta = new PrinterThread("A", c, a);
        new Thread(ta).start();
        Thread.sleep(1000L);
        PrinterThread tb = new PrinterThread("B", a, b);
        new Thread(tb).start();
        Thread.sleep(1000L);
        PrinterThread tc = new PrinterThread("C", b, c);
        new Thread(tc).start();

    }


    static class PrinterThread implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private PrinterThread(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }


        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);// 打印
                        count--;

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            prev.notifyAll();
                        } else {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

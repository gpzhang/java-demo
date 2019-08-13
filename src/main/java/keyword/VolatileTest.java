package keyword;

/**
 * @author haishen
 * @date 2018/9/13
 */
public class VolatileTest {

    private static volatile boolean isOver = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                }
                System.out.println("线程运行结束");
            }
        });
        thread.start();
        Thread.sleep(3000);
        isOver = true;
        System.out.println("已经修改isOver:" + isOver);
    }
}

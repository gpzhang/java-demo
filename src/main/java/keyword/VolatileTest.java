package keyword;

/**
 * @author haishen
 * @date 2018/9/13
 */
public class VolatileTest {
    private static boolean isOver = false;
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            int i=0;
            @Override
            public void run() {
                while (!isOver) {
                }
                System.out.println("结束");
            }
        });
        thread.start();
        Thread.sleep(3000);
        isOver = true;
    }
}

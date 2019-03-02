package queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue=new ArrayBlockingQueue(10);
        arrayBlockingQueue.put("1");
        arrayBlockingQueue.add("2");
    }
}

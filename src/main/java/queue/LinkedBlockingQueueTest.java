package queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue(10);
        linkedBlockingQueue.put("1");
        linkedBlockingQueue.add("2");
    }
}

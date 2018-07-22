package queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author haishen
 * @date 2018/7/22
 */
public class QueueMain {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        arrayBlockingQueue.put("123");
    }

}

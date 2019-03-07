package queue.block;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue(10);
        linkedBlockingQueue.put("1");
        linkedBlockingQueue.add("2");

        /**
         * 添加元素，元素入队列
         */
        linkedBlockingQueue.add("队列通用add方法");
        linkedBlockingQueue.offer("队列通用offer方法");
        linkedBlockingQueue.put("阻塞队列特有put方法");
        linkedBlockingQueue.offer("阻塞队列特有offer方法", 1, TimeUnit.SECONDS);

        /**
         * 队列通用删除元素，元素出队列
         */
        linkedBlockingQueue.remove();
        linkedBlockingQueue.poll();
        /**
         * 阻塞队列特有删除元素，元素出队列
         */
        linkedBlockingQueue.take();
        linkedBlockingQueue.poll(1, TimeUnit.SECONDS);

        /**
         * 查看队列元素
         */
        linkedBlockingQueue.element();
        linkedBlockingQueue.peek();
    }
}

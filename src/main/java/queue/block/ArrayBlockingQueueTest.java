package queue.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);

        /**
         * 添加元素，元素入队列
         */
        arrayBlockingQueue.add("队列通用add方法");
        arrayBlockingQueue.offer("队列通用offer方法");
        arrayBlockingQueue.put("阻塞队列特有put方法");
        arrayBlockingQueue.offer("阻塞队列特有offer方法", 1, TimeUnit.SECONDS);

        /**
         * 队列通用删除元素，元素出队列
         */
        arrayBlockingQueue.remove();
        arrayBlockingQueue.poll();
        /**
         * 阻塞队列特有删除元素，元素出队列
         */
        arrayBlockingQueue.take();
        arrayBlockingQueue.poll(1, TimeUnit.SECONDS);

        /**
         * 查看队列元素
         */
        arrayBlockingQueue.element();
        arrayBlockingQueue.peek();
    }
}

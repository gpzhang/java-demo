package queue.nobolck;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author haishen
 * @date 2019/6/13
 * <p>
 * 队列的表示形式：链表
 * 元素入队和出队不阻塞
 * 线程安全的原因：基于CAS控制并发访问
 * 未限定队列的大小
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add("123");
        concurrentLinkedQueue.peek();
    }
}

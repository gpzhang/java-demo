package queue.block;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2019/2/26
 * 队列的表示形式：链表
 * 阻塞的原因：基于Condition实现队列空和队列满的线程等待
 * 线程安全的原因：基于ReentrantLock可重入锁的来控制并发访问
 * 指定队列的大小，不可以动态扩容
 * <p>
 * 一个可改变大小的阻塞队列。其内部也维持着一个数据缓冲队列（该队列由一个链表构成），
 * 当生产者往队列中放入一个数据时，队列会从生产者手中获取数据，并缓存在队列内部，
 * 而生产者立即返回；只有当队列缓冲区达到最大值缓存容量时（LinkedBlockingQueue可以通过构造函数指定该值），
 * 才会阻塞生产者队列，直到消费者从队列中消费掉一份数据，生产者线程会被唤醒，反之对于消费者这端的处理也基于同样的原理。
 * 此队列按 FIFO（先进先出）原则对元素进行排序。创建其对象如果没有明确大小，默认值是Integer.MAX_VALUE
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

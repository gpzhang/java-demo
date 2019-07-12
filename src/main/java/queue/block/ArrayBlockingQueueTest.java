package queue.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author haishen
 * @date 2019/2/26
 * 队列的表示形式：数组
 * 阻塞的原因：基于Condition实现队列空和队列满的线程等待
 * 线程安全的原因：基于ReentrantLock可重入锁的来控制并发访问
 * 指定队列的大小，不可以动态扩容
 * <p>
 * 一个由数组支持的有界阻塞队列，在ArrayBlockingQueue内部，维护了一个定长数组，
 * 以便缓存队列中的数据对象。此队列按 FIFO（先进先出）原则对元素进行排序。
 * 创建其对象必须明确大小，像数组一样。在创建ArrayBlockingQueue时，
 * 我们还可以控制对象的内部锁是否采用公平锁，默认采用非公平锁
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

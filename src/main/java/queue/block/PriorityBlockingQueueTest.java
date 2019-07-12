package queue.block;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author haishen
 * @date 2019/2/26
 * <p>
 * 队列的表示形式：数组
 * 阻塞的原因：基于Condition实现队列空和队列满的线程等待
 * 线程安全的原因：基于ReentrantLock可重入锁的来控制并发访问
 * 指定队列的大小，可以动态扩容
 * <p>
 * PriorityBlockingQueue是一个支持优先级的无界阻塞队列。
 * 默认情况下元素采用自然顺序进行排序，
 * 也可以通过自定义类实现compareTo()方法来指定元素排序规则，
 * 或者初始化时通过构造器参数Comparator来指定排序规则。
 * <p>
 * 类似于LinkedBlockingQueue，但其所含对象的排序不是FIFO，
 * 而是依据对象的自然排序顺序或者是构造函数所带的Comparator决定的顺序。
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(10);
        priorityBlockingQueue.add("123");
    }
}

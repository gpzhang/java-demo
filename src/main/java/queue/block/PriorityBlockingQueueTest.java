package queue.block;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author haishen
 * @date 2019/2/26
 * 类似于LinkedBlockingQueue，但其所含对象的排序不是FIFO，
 * 而是依据对象的自然排序顺序或者是构造函数所带的Comparator决定的顺序。
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(10);
    }
}

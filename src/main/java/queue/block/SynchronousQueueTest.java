package queue.block;

import java.util.concurrent.SynchronousQueue;

/**
 * @author haishen
 * @date 2019/2/26
 * <p>
 * SynchronousQueue每个插入操作必须等待另一个线程进行相应的删除操作，
 * 因此，SynchronousQueue实际上没有存储任何数据元素，因为只有线程在删除数据时，
 * 其他线程才能插入数据，同样的，如果当前有线程在插入数据时，线程才能删除数据。
 * SynchronousQueue也可以通过构造器参数来为其指定公平性。
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.add("123");
        synchronousQueue.offer("345");
        synchronousQueue.add("34");
        synchronousQueue.put("45");
        System.out.println(synchronousQueue.peek());
    }
}

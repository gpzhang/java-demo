package queue.block;

import java.util.concurrent.DelayQueue;

/**
 * @author haishen
 * @date 2019/2/26
 * <p>
 * DelayQueue是一个存放实现Delayed接口的数据的无界阻塞队列，
 * 只有当数据对象的延时时间达到时才能插入到队列进行存储。
 * 如果当前所有的数据都还没有达到创建时所指定的延时期，则队列没有队头，
 * 并且线程通过poll等方法获取数据元素则返回null。所谓数据延时期满时，
 * 则是通过Delayed接口的getDelay(TimeUnit.NANOSECONDS)来进行判定，
 * 如果该方法返回的是小于等于0则说明该数据元素的延时期已满。
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue delayQueue = new DelayQueue();
    }
}

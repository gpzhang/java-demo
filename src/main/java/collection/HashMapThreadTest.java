package collection;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haishen
 * @date 2018/12/19
 * <p>
 * HashMap多线程并发操作导入CPU飙高到100%，在java8版本的扩容逻辑中已经修复掉，
 * 但是多线程并发操作HashMap仍然是线程不安全的，并发操作可能会导致数据丢失、数据被覆盖等并发问题
 */
public class HashMapThreadTest extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 1000000) {
            map.put(at.get(), at.get());
            map.get(at.get());
            at.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName() + " over!!!");
    }

    public static void main(String[] args) {
        HashMapThreadTest threadTest01 = new HashMapThreadTest();
        HashMapThreadTest threadTest02 = new HashMapThreadTest();
        HashMapThreadTest threadTest03 = new HashMapThreadTest();
        HashMapThreadTest threadTest04 = new HashMapThreadTest();
        threadTest01.start();
        threadTest02.start();
        threadTest03.start();
        threadTest04.start();
    }

}

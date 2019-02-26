package collection;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haishen
 * @date 2018/12/19
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
        System.out.println(Thread.currentThread().getName()+" over!!!");
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

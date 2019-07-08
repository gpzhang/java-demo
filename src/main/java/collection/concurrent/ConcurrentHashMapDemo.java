package collection.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haishen
 * @date 2019/3/7
 * <p>
 * 1.8版本舍弃了之前版本的segment实现方式，
 * 并且大量使用了synchronized，以及CAS无锁操作以保证ConcurrentHashMap操作的线程安全性。
 * 至于为什么不用ReentrantLock而是Synchronized呢？
 * 实际上，synchronized做了很多的优化，包括偏向锁，轻量级锁，重量级锁，可以依次向上升级锁状态，但不能降级
 * <p>
 * 底层数据结构：数组+链表+红黑树
 */
public class ConcurrentHashMapDemo {
    private static final int MAXIMUM_CAPACITY = 1 << 4;

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap(10);
        concurrentHashMap.put("1", "2");
        concurrentHashMap.get("1");
        concurrentHashMap.size();
        concurrentHashMap.clear();

        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(MAXIMUM_CAPACITY >>> 1);
    }
}

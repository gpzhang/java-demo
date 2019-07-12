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
 * 数组最长为2的30次方
 * 扩容操作会导致节点元素重新hash到不同的位置，这个过程涉及到链表反转的情况发生
 * <p>
 * 扩容过程中重要的几点操作（扩容主要目的就是在尽可能支持并发操作的情况下，对老的链表节点重新hash索引位置、对红黑树节点进行重新hash索引位置,并判断是否需要树转链表）
 * 1、新建扩容后的数组
 * 2、遍历老数组中的所有节点元素
 * 3、判断老数组中的节点元素的及其hash值，做相应操作
 * 3.1老数组中i位置没有元素，cas操作写入ForwardingNode节点
 * 3.2老数组中i位置有元素且为ForwardingNode类型，处理下一个节点元素
 * 3.3 以上都不符合,说明该位置的元素出现存在多个hash值索引位置相同的key，锁住该位置头节点元素，重新hash
 * 4、直到老数组索引位置的元素都处理完成，扩容结束
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

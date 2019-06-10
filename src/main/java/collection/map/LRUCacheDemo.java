package collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU（Least Recently Used，最近最少使用）
 *
 * @author haishen
 * @date 2019/6/10
 * 基于LinkedHashMap实现的最近最少使用缓存失效策略
 *
 * 实现方式：
 * 1、指定accessOrder=true，即LinkedHashMap维护的链表按照访问顺序变动；
 * 2、重写父类LinkedHashMap的removeEldestEntry方法
 */
public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    LRUCacheDemo() {
        this(MAX_NODE_NUM);
    }

    LRUCacheDemo(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    /**
     * 重写父类LinkedHashMap的removeEldestEntry方法
     * 指定移除操作自定义的判断逻辑
     * <p>
     * 判断节点数是否超限
     *
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LRUCacheDemo<String, String> lruCacheDemo = new LRUCacheDemo<>(2);
        lruCacheDemo.put("1", "123");
        lruCacheDemo.put("2", "1234");
        lruCacheDemo.put("3", "12345");
        lruCacheDemo.put("4", "123456");
        System.out.println(lruCacheDemo);
    }

}

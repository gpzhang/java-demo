package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haishen
 * @date 2019/3/7
 */
public class ConcurrentHashMapDemo {
    private static final int MAXIMUM_CAPACITY = 1 << 4;

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap(10);
        concurrentHashMap.put("1", "2");
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(MAXIMUM_CAPACITY >>> 1);
    }
}

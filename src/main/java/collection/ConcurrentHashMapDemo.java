package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haishen
 * @date 2019/3/7
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", "2");
    }
}

package collection.concurrent;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author haishen
 * @date 2019/6/20
 */
public class ConcurrentSkipListSetDemo {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> skipListSet = new ConcurrentSkipListSet();
        skipListSet.add("123");
    }
}

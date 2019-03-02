package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap(1);
        hashMap.put(null,"1");
        hashMap.put("1","12");
        System.out.println(hashMap.size());
    }
}

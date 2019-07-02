package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(null, "1");
        hashMap.put("1", "12");
        hashMap.put("3", null);
        hashMap.get("3");
        hashMap.remove("2");
        hashMap.replace("4", "666");
        hashMap.remove("2", "4");
//        hashMap.clear();
        System.out.println(hashMap.size());

        Set keys = hashMap.keySet();
        Iterator ite = keys.iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            System.out.println("key:{" + key + "}--->value:{" + hashMap.get(key) + "}");
        }

        System.out.println("=============");

        //代码片段中用 foreach 遍历 keySet 方法产生的集合，在编译时会转换成用迭代器遍历，等价上面的遍历方式：
        for (String key : hashMap.keySet()) {
            System.out.println("key:{" + key + "}--->value:{" + hashMap.get(key) + "}");
        }

        System.out.println("**************");

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iterator.next();
            System.out.println("key:{" + entry.getKey() + "}--->value:{" + entry.getValue() + "}");
        }
    }
}

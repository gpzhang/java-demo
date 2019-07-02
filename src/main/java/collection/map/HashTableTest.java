package collection.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * Hashtable
 * 是一个线程安全集合、
 * 节点数据使用的是数组+链表的存储方式、
 * 同时key和value不允许为null、
 *
 * @author haishen
 * @date 2019/2/26
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable();
        hashtable.put("ss", "ss");
        hashtable.put("ss02", "ss");
        hashtable.put("ss01", "ss");
        hashtable.get("ss");
        hashtable.remove("ss");
        hashtable.replace("ss", "44");

        Set keys = hashtable.keySet();
        Iterator ite = keys.iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            System.out.println("key:{" + key + "}--->value:{" + hashtable.get(key) + "}");
        }

        System.out.println("========");

        //代码片段中用 foreach 遍历 keySet 方法产生的集合，在编译时会转换成用迭代器遍历，等价上面的遍历方式：
        for (String key : hashtable.keySet()) {
            System.out.println("key:{" + key + "}--->value:{" + hashtable.get(key) + "}");
        }
    }
}

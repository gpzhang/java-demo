package collection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 通用Map
 * 用于在应用程序中管理映射，通常在 java.util 程序包中实现
 * HashMap、Hashtable、Properties、LinkedHashMap、
 * IdentityHashMap、TreeMap、WeakHashMap、
 * ConcurrentHashMap
 * <p>
 * 专用Map
 * 通常我们不必亲自创建此类Map，而是通过某些其他类对其进行访问
 * java.util.jar.Attributes、javax.print.attribute.standard.PrinterStateReasons、java.security.Provider、java.awt.RenderingHints、javax.swing.UIDefaults
 * <p>
 * 自行实现Map
 * 一个用于帮助我们实现自己的Map类的抽象类 AbstractMap
 *
 * @author haishen
 * @date 2019/2/26
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ear", "er");
        linkedHashMap.put("ear02", "er");
        linkedHashMap.put("ear01", "er");
        linkedHashMap.get("ear");
        linkedHashMap.getOrDefault("ear", "34");
        linkedHashMap.replace("ear", "34");
        linkedHashMap.remove("ear");

        /**
         * key遍历。key遍历是底层是entry遍历的结果返回key
         *
         * 在设定LinkedHashMap按访问顺序输出时，按照key遍历的方式时，如果获取key对于的value
         * 取下一个key时会抛ConcurrentModificationException异常，
         * 原因是：get操作修改了modCount（元素修改次数）的值和初始化迭代器时设置值不一致了
         */
        Set keys = linkedHashMap.keySet();
        Iterator ite = keys.iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            System.out.println("key:{" + key + "}--->value:{" + linkedHashMap.get(key) + "}");
        }

        System.out.println("************");

        /**
         * entry遍历
         */
        Set entrySet = linkedHashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iterator.next();
            System.out.println("key:{" + entry.getKey() + "}--->value:{" + entry.getValue() + "}");
        }

    }
}

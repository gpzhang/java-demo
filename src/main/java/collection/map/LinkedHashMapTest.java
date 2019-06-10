package collection.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
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

        Set keys = linkedHashMap.keySet();
        Iterator ite = keys.iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            System.out.println("key:{" + key + "}--->value:{" + linkedHashMap.get(key) + "}");
        }

    }
}

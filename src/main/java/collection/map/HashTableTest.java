package collection.map;

import java.util.Hashtable;
import java.util.Iterator;
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

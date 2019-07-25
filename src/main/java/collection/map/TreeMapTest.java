package collection.map;

import java.util.NavigableMap;
import java.util.TreeMap;

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
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap();
        treeMap.put("ss", "ss");

        // creating tree map
        NavigableMap<Integer, String> treemap = new TreeMap<Integer, String>();

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");
        /**
         * ceilingEntry(K key)方法用来返回与该键至少大于或等于给定键，如果不存在这样的键的键值对，则返回null相关联。
         */
        System.out.println("Ceiling entry for 4: " + treemap.ceilingEntry(4));
        System.out.println("Ceiling entry for 5: " + treemap.ceilingEntry(5));
        System.out.println("Ceiling entry for 7: " + treemap.ceilingEntry(7));
        /**
         * dubbo负载均衡中一致性hash实现的节点数据存储没有使用hash表，而是使用了TreeMap只存储了请求提供者的信息，
         * 然后通过ceilingEntry方法找到最近的请求提供者，其中key就是对应hash值
         */
    }
}

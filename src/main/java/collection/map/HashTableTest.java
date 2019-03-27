package collection.map;

import java.util.Hashtable;

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
    }
}

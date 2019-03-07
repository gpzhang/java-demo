package collection.list;

import java.util.Vector;

/**
 * Vector 与ArrayList基本一致，其对应方法时线程安全的，增加了关键词 synchronized
 *
 * @author haishen
 * @date 2019/2/26
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(10);
        vector.add("1");
        vector.add("3");
        vector.get(1);
        vector.remove("1");
        vector.remove(0);
    }
}

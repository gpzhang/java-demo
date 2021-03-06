package collection.list;

import java.util.Iterator;
import java.util.Vector;

/**
 * Vector 与ArrayList基本一致，其对应方法是线程安全的，增加了关键词 synchronized
 *
 * @author haishen
 * @date 2019/2/26
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("3");
        vector.get(1);
        vector.remove("1");
        vector.remove(0);

        System.out.println("*******");
        Iterator<String> it = vector.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

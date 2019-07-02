package collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 线程不安全
 * add执行操作
 * 创建尾节点，
 * <p>
 * <p>
 * 双向链表
 *
 * @author haishen
 * @date 2019/2/26
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("123");
        list.add("1");
        list.add(null);
        list.add(2, "34");
        list.remove(0);
        list.remove("1");
        System.out.println(list.size());
        System.out.println(list.get(0));

        System.out.println("*******");
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

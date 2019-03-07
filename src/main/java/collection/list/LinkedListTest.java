package collection.list;

import java.util.LinkedList;
import java.util.List;

/**
 * 1、当初始化ArrayList 没有指定时默认初始化大小为10
 * 2、ArrayList的扩容逻辑, 判断已写入的数量+1如果大于整个当初始化ArrayList的的数组大小
 * 2.1 对原来的数组大小增加右移一位加上原来的大小 判断是否大于已写入的数量+1
 * 2.2 如果大于的话，则取扩容大小为（已写入的数量+1）
 * 2.3 如果小于的话，则取扩容大小为（对原来的数组大小增加右移一位加上原来的大小）
 * 3、ArrayList扩容时数据的处理，全copy
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
        list.remove(0);
        list.remove("1");
        System.out.println(list.size());

    }
}

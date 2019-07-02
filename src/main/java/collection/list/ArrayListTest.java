package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 线程不安全
 * 当初始化ArrayList对象
 * 1、当初始化ArrayList 没有指定时默认初始化大小为10
 * <p>
 * add操作执行逻辑
 * 2、首先判断是否需要扩容ArrayList的扩容逻辑,
 * 判断是否为空集合，如果是空集合，则扩容参数（需要的最小空间容量）大小为10，否则扩容参数为已写入的数量+1
 * 如果需要扩容的值（需要的最小空间容量）小于数组的大小，则不必扩容。
 * 否则，走扩容判断逻辑
 * 2.1 原来数组的大小加上对原来的数组长度右移一位（取模运算）
 * 2.2 判断新容量是否大于已写入的数量+1（需要的最小容量）
 * 2.2 如果大于的话，则取扩容大小为（新容量为2.1的值），选大的值主要是为了减少扩容的次数
 * 2.3 如果小于的话，则取扩容大小为（需要的最小容量）
 * 2.4 如果扩增的新的容量的只值过大（大于 Integer.MAX_VALUE - 8），取最大值
 * 2.4 ArrayList扩容时数据的处理，全copy到新的指定长度的对象
 * <p>
 * 3、把添加的数据赋值到指定位置的数组中
 * <p>
 * get操作
 * 获取数组指定位置的数据
 * <p>
 * 移除操作
 * <p>
 * remove(int index)，
 * 获取移除位置的元素，通过size - index - 1计算移动元素的数量，
 * 将原数据数组的指定位置的数据向前移动一个位置，然后将数组的最后一位设置为null
 * remove(Object o)
 * 从头开始循环遍历数组，判断元素是否等于指定移除的值，如果过等于走remove(int index)的移除逻辑，
 * 并且不在判断数组中是否还有相等的值
 *
 * @author haishen
 * @date 2019/2/26
 */
public class ArrayListTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(1);
        list.add("123");
        list.add("1");
        list.add(null);
        list.remove("1");
        list.remove(0);
        System.out.println(list.size());
        System.out.println(list.get(0));

        List<String> synArrayList = Collections.synchronizedList(new ArrayList<String>());

        System.out.println("*******");
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

package collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet 底层时用HashMap来存储元素的
 * 分析HashSet源码 等同于分析HashMap源码
 *
 * @author haishen
 * @date 2019/2/26
 *
 * 2，hashSet去重原理：1，hashCode 2，equals是否相同
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(1);
        stringSet.add(null);
        stringSet.add("123");
        stringSet.remove("123");
        stringSet.contains("123");
        System.out.println(stringSet.size());
    }
}

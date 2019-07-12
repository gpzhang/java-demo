package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author haishen
 * @date 2019/2/26
 * <p>
 * Hash扩容逻辑
 * 1、如果数组容量为0且指定了阀值,则扩容后的数组大小为指定的阀值大小（对应创建HashMap对象时指定初始容量的情况）
 * 2、如果数组容量为0且未指定阀值,则扩容后的数组大小为默认大小16（对应创建HashMap对象时未指定初始容量的情况）
 * 3、其他情况则是在数组已经被初始化后的扩容逻辑，即老数组容量大于0
 * 3.1 老数组容量已经大于等于数组容量最大值（2的30次方），不扩容
 * 3.2 新数组容量扩大为老数组容量的2倍
 * 4、阀值为当前数组容量的四分之三
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(null, "1");
        hashMap.put("1", "12");
        hashMap.put("3", null);
        hashMap.get("3");
        hashMap.remove("2");
        hashMap.replace("4", "666");
        hashMap.remove("2", "4");
//        hashMap.clear();
        System.out.println(hashMap.size());

        Set keys = hashMap.keySet();
        Iterator ite = keys.iterator();
        while (ite.hasNext()) {
            String key = (String) ite.next();
            System.out.println("key:{" + key + "}--->value:{" + hashMap.get(key) + "}");
        }

        System.out.println("=============");

        //代码片段中用 foreach 遍历 keySet 方法产生的集合，在编译时会转换成用迭代器遍历，等价上面的遍历方式：
        for (String key : hashMap.keySet()) {
            System.out.println("key:{" + key + "}--->value:{" + hashMap.get(key) + "}");
        }

        System.out.println("**************");

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iterator.next();
            System.out.println("key:{" + entry.getKey() + "}--->value:{" + entry.getValue() + "}");
        }
    }
}

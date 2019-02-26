package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(1);
        stringSet.add(null);
        stringSet.add("123");
        System.out.println(stringSet.size());
    }
}

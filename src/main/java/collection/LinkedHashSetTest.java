package collection;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author haishen
 * @date 2019/2/26
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("1");
        linkedHashSet.contains("1");
    }
}

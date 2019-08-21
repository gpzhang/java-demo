package collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author haishen
 * @date 2019/2/26
 * 1，treeSet去重原理：compareTo
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("34");
        treeSet.add("34");
    }
}

import spi.Log;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class Main {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.remove((Object) 2);
        arrayList.sort(null);
        Vector vector = new Vector();
        vector.add(122);
        vector.get(0);
        LinkedList linkedList = new LinkedList();

        HashSet hashSet = new HashSet();
        hashSet.add("123");
        TreeSet treeSet = new TreeSet();
        treeSet.add("234");

        List<String> strings = Arrays.asList("6", "1", "3", "1", "2");
        Collections.sort(strings);//sort方法在这里
        for (String string : strings) {
            System.out.println(string);
        }

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(10);


        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        Iterator<Log> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Log log = iterator.next();
            log.execute();
        }
    }
}

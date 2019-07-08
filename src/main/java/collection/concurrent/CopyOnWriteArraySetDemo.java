package collection.concurrent;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet 线程安全
 * 1、写入和删除操作时是锁住整个对象，线程安全
 * 2、读数据时无锁，无并发操作安全问题
 *
 * @author haishen
 * @date 2018/10/11
 */
public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet();
        set.add("123");
        set.remove(0);
        set.remove("123");
    }
}

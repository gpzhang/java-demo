package collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList 线程安全
 * 1、写入和删除操作时是锁住整个对象，线程安全
 * 2、读数据时无锁，无并发操作安全问题
 *
 * @author haishen
 * @date 2018/10/11
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("123");
        list.get(0);
        list.remove(0);
        list.remove("123");
    }
}

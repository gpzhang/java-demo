package collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 有很多业务往往是读多写少的
 * 能够接受牺牲数据实时性,数据最终一致性
 * <p>
 * CopyOnWriteArrayList 线程安全
 * 1、写入和删除操作时是锁住整个对象，线程安全(基于可重入锁ReentrantLock锁住整个add方法来控制并发添加数据)
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

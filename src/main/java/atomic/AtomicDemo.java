package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haishen
 * @date 2019/3/4
 * 在J.U.C下的atomic包提供了一系列的操作简单，性能高效，
 * 并能保证线程安全的类去更新
 * 基本类型变量，数组元素\引用类型、以及更新对象中的字段类型。
 * <p>
 * atomic包下的这些类都是采用的是乐观锁策略去原子更新数据，在java中则是使用CAS操作具体实现。
 * <p>
 * CAS存在的问题
 * 1、ABA问题
 * 2、自旋时间可能会很长
 */
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}

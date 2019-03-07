package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haishen
 * @date 2019/3/4
 */
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}

package genericity;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型擦除demo
 *
 * @author haishen
 * @date 2019/3/13
 */
public class GenericityErasureDemo {

    public static void main(String[] args) {
        demo();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (Integer i : list) {
            sum = sum + i;
        }
    }

    private static void demo() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 321L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(e.equals(f));
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }
}

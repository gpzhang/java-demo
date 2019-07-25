/**
 * @author haishen
 * @date 2018/5/21
 * 浮点数的比较，因为受精度限制
 * 判断浮点数对象是否相同，要用Double.doubleToLongBits将double值转换过后再比较
 */
public class Main {

    public static String name = "gp";

    public static void main(String[] args) {

        Float x = 12.4F;
        Float y = 12.4F;

        System.out.println(x == y);
        System.out.println(x.equals(y));

        Double m = 13.4d;
        Double n = 13.4d;
        System.out.println(m == n);
        System.out.println(m.equals(n));

        float j = 13.3f;
        float k = 13.3f;
        System.out.println(j == k);


        System.out.println(name);
        name = "hs";
        System.out.println(name);
    }
}

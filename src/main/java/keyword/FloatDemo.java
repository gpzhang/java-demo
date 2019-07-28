package keyword;

/**
 * @author haishen
 * @date 2019/7/26
 * 浮点数的比较，因为受精度限制
 * 比较时会进行类型转换，转换到指定精度的二进制位进行比较
 * 判断浮点数对象是否相同，
 * 要用Float.floatToIntBits将float值转换过后再比较
 * 要用Double.doubleToLongBits将double值转换过后再比较
 * <p>
 * 比较分类：
 * Float对象和Float对象通过==比较，不相等，因为不是同一个对象；
 * Double对象和Double对象通过==比较，不相等，因为不是同一个对象；
 * Float对象和Float对象通过equals比较，Float.floatToIntBits将float值转换到指定精度的二进制位进行比较，转换过后再比较
 * Double对象和Double对象通过equals比较，doubleToLongBits将double值转换到指定精度的二进制位进行比较，转换过后再比较
 */
public class FloatDemo {

    public static void main(String[] args) {
        Float x = 12.3F;
        Float y = 12.3F;

        System.out.println(x == y);
        System.out.println(x.equals(y));

        float j = 12.3f;
        float k = 12.3f;
        System.out.println(j == k);


        Double m = 12.3d;
        Double n = 12.3d;
        System.out.println(m == n);
        System.out.println(m.equals(n));

        System.out.println(x.equals(m));

    }
}

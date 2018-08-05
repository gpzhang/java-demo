package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
        }
    }

    static void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = Class.forName(ReflectService.class.getName()).newInstance();

        Method method = object.getClass().getMethod("print", String.class);
        System.out.println(method.getDeclaringClass());
        method.invoke(object, "123");
    }
}

package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("reflect.Article");

        Class<?>[] argTypes = {Long.class};
        Long idParam = 666L;
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(" Constructor<?>[].size:" + constructors.length);
        Constructor<?> constr = clazz.getConstructor(argTypes);
        /**
         * 反射调用Article的有参构造函数创建Article实例
         */
        Article article = (Article) constr.newInstance(idParam);
        System.out.println(article.getId());
        test();

    }

    static void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = Class.forName(ReflectService.class.getName()).newInstance();

        Method method = object.getClass().getMethod("print", String.class);
        System.out.println(method.getDeclaringClass());
        method.invoke(object, "123");
    }
}

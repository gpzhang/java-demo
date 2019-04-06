package classloader;

/**
 * @author haishen
 * @date 2019/4/6
 */
public class Main {

    public static void main(String[] args) throws Exception {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> clazz = Class.forName("HaiShen", true, mcl);
        Object obj = clazz.newInstance();

        System.out.println(obj);
        //打印出我们的自定义类加载器
        System.out.println(obj.getClass().getClassLoader());
    }
}

package classloader;

/**
 * 我们有这样一个结论，除了启动类加载器Bootstrap ClassLoader，
 * 其他的类加载器都是ClassLoader的子类。
 * <p>
 * AppClassLoader与ExtClassLoader都是Launcher的内部类;都继承了URLClassLoader类
 *
 * @author haishen
 * @date 2019/4/6
 */
public class Main {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = Class.forName("HaiShen", true, myClassLoader);
        Object obj = clazz.newInstance();

        System.out.println(obj);
        //打印出我们的自定义类加载器
        System.out.println("自定义类加载器:" + obj.getClass().getClassLoader());

        //应用程序类加载器
        ClassLoader classLoader = Main.class.getClassLoader();
        //表示当前线程的类加载器——应用程序类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("当前类加载器:" + classLoader);
        System.out.println("线程上线文类加载器:" + contextClassLoader);
        System.out.println("系统类加载器:" + systemClassLoader);
        System.out.println("系统类加载器(应用类加载器)父加载器-->(扩展类加载器):" + systemClassLoader.getParent());
        /**
         * 执行结果为null不是说ExtClassLoader没有父加载器,而是因为Bootstrap ClassLoader使用C++写的。
         */
        System.out.println("扩展类加载器父加载器-->(启动类加载器):" + systemClassLoader.getParent().getParent());

        System.out.println("====================");
        System.out.println("java.class.path路径目录:" + System.getProperty("java.class.path"));
        System.out.println("====================");
        System.out.println("java.ext.dirs路径目录:" + System.getProperty("java.ext.dirs"));

    }
}

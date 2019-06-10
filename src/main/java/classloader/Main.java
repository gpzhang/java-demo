package classloader;

/**
 * 我们有这样一个结论，除了启动类加载器Bootstrap ClassLoader，
 * 其他的类加载器都是ClassLoader的子类。
 * <p>
 * AppClassLoader与ExtClassLoader都是Launcher的内部类;都继承了URLClassLoader类
 * <p>
 * 虚拟机加载类的途径
 * 1、由 new 关键字创建一个类的实例
 * 2、调用 Class.forName() 方法
 * 3、调用某个 ClassLoader 实例的 loadClass() 方法
 * <p>
 * Class.forName与ClassLoader.loadClass区别：
 * Class的装载包括3个步骤：加载（loading）,连接（link）,初始化（initialize）.
 * Class.forName(className)实际上是调用Class.forName(className, true, this.getClass().getClassLoader())。
 * 第二个参数，是指Class被loading后是不是必须被初始化。
 * ClassLoader.loadClass(className)实际上调用的是ClassLoader.loadClass(name, false)，第二个参数指Class是否被link。
 * Class.forName(className)装载的class已经被初始化，
 * 而ClassLoader.loadClass(className)装载的class还没有被link。
 * 一般情况下，这两个方法效果一样，都能装载Class。但如果程序依赖于Class是否被初始化，就必须用Class.forName(name)了。
 * <p>
 * 参考博客：https://blog.csdn.net/obession/article/details/78247165
 *
 * @author haishen
 * @date 2019/4/6
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String classFilePath = Main.class.getResource("/").getPath();
        System.out.println(classFilePath);

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("Main");
//        Class<?> clazz = Class.forName("HaiShen", true, myClassLoader);
        Object obj = clazz.newInstance();

        System.out.println(obj);
        //打印出我们的自定义类加载器
        System.out.println("自定义类加载器:" + obj.getClass().getClassLoader());
        System.out.println("自定义类加载器父加载器:" + obj.getClass().getClassLoader().getParent());

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

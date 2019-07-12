package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author haishen
 * @date 2019/4/6
 * 不同的类加载器为相同名称的类创建了额外的名称空间。
 * 相同名称的类可以并存在 Java 虚拟机中，只需要用不同的类加载器来加载它们即可。
 * 不同类加载器加载的类之间是不兼容的，
 * 这就相当于在Java虚拟机内部创建了一个个相互隔离的 Java 类空间
 * 这种技术在许多框架中都被用到。
 * <p>
 * <p>
 * 我们可以自定义类加载器，只需继承ClassLoader抽象类，并重写findClass方法
 * （如果要打破双亲委派模型，需要在实现类中直接重写loadClass方法）。原因可以查看ClassLoader的源码：
 * 例如：tomcat自定义的类加载器的WebAppClassLoader重写了loadClass()方法
 * 对于一些未加载的非基础类(Object,String等)，各个web应用自己的类加载器(WebAppClassLoader)会优先加载，
 * 加载不到时再交给commonClassLoader走双亲委托。
 * 具体的加载逻辑位于WebAppClassLoaderBase.loadClass()方法中
 */

/**
 * 虚拟机在进行类加载的时候会调用类加载器的私有方法，loadClassInternal(String name)；
 * loadClass(name)方法内部会调用loadClass(String name, boolean resolve)；
 * <p>
 * 这个是ClassLoader中的loadClass方法，大致流程如下：
 * 1）检查类是否已加载，如果是则不用再重新加载了；
 * 2）如果未加载，则通过父类加载（依次递归）或者启动类加载器（bootstrap）加载；
 * 3）如果还未找到，则调用本加载器的findClass方法；
 * <p>
 * // This method is invoked by the virtual machine to load a class.
 * private Class<?> loadClassInternal(String name) throws ClassNotFoundException{
 * // For backward compatibility, explicitly lock on 'this' when
 * // the current class loader is not parallel capable.
 * if (parallelLockMap == null) {
 * synchronized (this) {
 * return loadClass(name);
 * }
 * } else {
 * return loadClass(name);
 * }
 * }
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader() {
        /**
         * 这个构造方法中去调用ClassLoader无参构造方法
         * 从ClassLoader源码中可以得出：调用此构造方法默认会让系统类加载器成为该类加载器的父加载器
         */
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/haishen/study/java-demo/target/classes/MainDemo.class");
//        File file = new File("/Users/haishen/data/HaiShen.class");

        try {
            byte[] bytes = getClassBytes(file);
            //defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

}

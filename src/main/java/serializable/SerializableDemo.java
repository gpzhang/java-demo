package serializable;

import java.io.*;

/**
 * @author haishen
 * @date 2019/8/20
 * <p>
 * 普通的java对象实现序列化，一般的操作：
 * 1、实现serializable接口
 * 2、生成序列号，或者使用默认的
 * 3、自定义序列化和反序列化需要对操作类添加定义了writeObject(ObjectOutputStream oos)和readObject(ObjectInputStream ois)方法
 * 4、调用ObjectOutputStream的writeObject和ObjectInputStream的readObject方法进行序列化和反序列化
 * <p>
 * Dubbo序列化
 * Dubbo为了丰富更多序列化实现方案，做了抽象和封装，主要有以下几个核心的接口
 * Serialization，封装序列化和反序列化的实现细节，提供序列化和反序列化统一执行入口。
 * ObjectOutput，序列化接口。不同序列化实现方案的序列化实现逻辑
 * ObjectInput，反序列化接口。不同反序列化实现方案的反序列化实现逻辑
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("/Users/haishen/data/temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestObject testObject = new TestObject();
        oos.writeObject(testObject);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("/Users/haishen/data/temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestObject deTest = (TestObject) ois.readObject();
        System.out.println(deTest.testValue);
        System.out.println(deTest.parentValue);
        System.out.println(deTest.address.nation);
    }
}

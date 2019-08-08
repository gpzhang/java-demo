package proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class ProxyTest {
    public static void main(String[] args) {
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloService helloService = new HelloServiceImpl();

        /**
         * 动态代理的实现步骤
         * 1、指定类加载器
         * 2、指定代理的接口数组
         * 3、指定处理代理接口的InvocationHandler实现
         * 代理创建的实现类：继承了Proxy类和实现了代理接口
         * 和代理接口的同名方法（重写了接口实现）内部的实现逻辑是通过执行父类Proxy的属性InvocationHandler的实现类的invoker方法，
         * 实现动态添加执行逻辑的功能
         * 具体可以看生成的代理实现类对应的class文件
         */
        HelloService helloServiceProxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), new InvocationHandlerImpl(helloService));

        helloServiceProxy.sayHello("haishen", "spring");

    }
}


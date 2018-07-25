package proxy;

import java.lang.reflect.Proxy;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class ProxyTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService helloServiceProxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), new HelloProxy(helloService));
        helloServiceProxy.sayHello("haishen", "spring");
    }
}

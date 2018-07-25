package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2018/5/13
 */
public class HelloProxy implements InvocationHandler {

    public Object target;

    public HelloProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类操作开始---->");
        method.invoke(target, args);
        System.out.println("代理类操作结束---->");
        return null;
    }
}

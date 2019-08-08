package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2019/8/5
 */
public class UserServiceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("拦截器执行---》");
        Object obj = methodProxy.invokeSuper(o, objects);
        return obj;
    }
}

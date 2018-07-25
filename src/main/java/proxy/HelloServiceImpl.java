package proxy;

/**
 * @author haishen
 * @date 2018/5/13
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String who, String content) {
        System.out.println(who + " say hello " + content);
    }
}

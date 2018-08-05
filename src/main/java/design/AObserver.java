package design;

import java.util.Observable;
import java.util.Observer;

/**
 * @author haishen
 * @date 2018/7/31
 */
public class AObserver implements Observer {

    public AObserver(ServerManager sm) {
        super();
        //注册加入观察者
        sm.addObserver(this);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("AObserver receive:Data has changed to " + ((ServerManager) arg0).getData());

    }

}
package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author haishen
 * @date 2018/5/21
 */
public class SpiDemo {

    public static void main(String[] args) {

        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        Iterator<Log> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Log log = iterator.next();
            log.execute();
        }
    }
}

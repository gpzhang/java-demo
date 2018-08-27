package spi;

/**
 * @author haishen
 * @date 2018/8/27
 */
public class Logback implements Log {
    @Override
    public void execute() {
        System.out.println("-----Logback-----");

    }
}

package spi;

/**
 * @author haishen
 * @date 2018/8/27
 */
public class Log4j implements Log{
    @Override
    public void execute() {
        System.out.println("-----Log4j-----");
    }
}

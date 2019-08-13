package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author haishen
 * @date 2019/8/13
 * 异常体系
 * <p>
 * RuntimeException 是不检查的异常，也就是编译代码的过程中编译器检不会去检查
 * Exception 体系下除了RuntimeException其他的都是可以在代码编译过程中进行异常检查的，
 * 所以我们的代码中要对这类异常显示的进行异常处理
 * <p>
 * trycatch抛出的异常时，需要生成异常的栈追踪，
 * 生成现场快照，消耗系统资源
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        //RuntimeException，可以不出来，代码也能编译通过
        int i = 10 / 0;
        try {
            i = 10 / 0;
        } catch (ArithmeticException throwable) {
            throwable.printStackTrace();
        }
        File file = new File("/Users/haishen/data/tm.txt");
        try {
            //非RuntimeException，所以需要显示处理异常
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

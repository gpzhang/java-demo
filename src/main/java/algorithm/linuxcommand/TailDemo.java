package algorithm.linuxcommand;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * linux的命令本质也是对应的执行程序
 * 不过是把linux的实现用java实现一遍，注重思考逻辑
 *
 * @author haishen
 * @date 2019/8/16
 */
public class TailDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/haishen/data/text0816.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

    }
}

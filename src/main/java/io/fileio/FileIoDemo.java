package io.fileio;

import java.io.*;

/**
 * @author haishen
 * @date 2019/6/25
 * <p>
 * 输入输出是相对内存而言的。
 * <p>
 * 输入到内存的流：字节流InputStream、字符流Reader
 * FileInputStream：把文件作为数据源，从文件中读取内容写入到内存；
 * ByteArrayInputStream：把内存中的一个缓冲区作为输入源，从这个缓冲区内存中读取数据字节；
 * <p>
 * <p>
 * 从内存中输出出去的流： 字节流OutputStream、字符流Writer
 * <p>
 * 缓冲流
 * BufferedInputStream
 * BufferedReader
 * <p>
 * <p>
 * 字符流转成字节流：OutputStreamWriter，OutputStreamWriter是Writer的子类，将输出的字符流转换成字节流。
 * 字节流转成字符流：InputStreamReader，InputStreamReader是Reader的子类，将输入的字节流转换成字符流。
 */
public class FileIoDemo {

    public static void main(String[] args) throws Exception {
        FileIoDemo fileIoDemo = new FileIoDemo();
        fileIoDemo.outputStreamDemo(fileIoDemo.inputStreamDemo());
        fileIoDemo.writerDemo(fileIoDemo.readerDemo());
    }

    /**
     * 文件流的字节流读取一般分以下四步：
     * 1、创建文件对象
     * 2、用流装载文件
     * 3、如果用缓冲区，则用缓冲区装载流（即对步骤2的流对象进行装饰），用缓冲区是为了提高读写性能
     * 4、开始读写操作
     **/
    private InputStream inputStreamDemo() throws Exception {
        File file = new File("/Users/haishen/data/tm.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        return bufferedInputStream;
    }

    private void outputStreamDemo(InputStream inputStream) throws Exception {
        File outFile = new File("/Users/haishen/data/tm-out.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int temp;
        while ((temp = inputStream.read()) != -1) {
            bufferedOutputStream.write(temp);
        }
    }

    /**
     * 文件的字符流读取步骤和字节流类似
     *
     * @throws Exception
     */
    private Reader readerDemo() throws Exception {
        File file = new File("/Users/haishen/data/tm.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }


    private void writerDemo(Reader reader) throws Exception {
        File outFile = new File("/Users/haishen/data/tm-writer.txt");
        FileWriter fileWriter = new FileWriter(outFile);
        int temp;
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((temp = reader.read()) != -1) {
            bufferedWriter.write(temp);
        }
    }
}

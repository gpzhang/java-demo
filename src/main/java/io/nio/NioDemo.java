package io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @author haishen
 * @date 2019/5/26
 */
public class NioDemo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/haishen/data/nio/fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/Users/haishen/data/nio/toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        /**
         * 目标通道接收源通道传递的数据
         */
        toChannel.transferFrom(fromChannel, position, count);
        /**
         * 数据从源通道传递到目标通道
         */
        fromChannel.transferTo(position, count, toChannel);


        ByteBuffer buf = ByteBuffer.allocate(48);

        //Selector的创建
        Selector selector = Selector.open();

        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

    }
}

package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author haishen
 * @date 2019/5/26
 */
public class ServerSocketChannelTwoDemo {

    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8888;
    static Selector selector = null;
    static ServerSocketChannel ssc = null;

    static boolean running = true;

    public static void main(String[] args) throws Exception {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(PORT));
        ssc.configureBlocking(true);
        new Thread(new AcceptorDemo()).start();
        selector();
    }


    static class AcceptorDemo implements Runnable {

        @Override
        public void run() {
            while (running) {
                System.out.println("========handleAccept,start");
                try {
                    handleAccept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("========handleAccept,end");
            }
        }
    }


    public static void handleAccept() throws IOException {

        //调用了它的accept()方法 ,来获取刚到达的socket的句柄,返回的 对象的类型是SocketChannel
        SocketChannel sc = ssc.accept();
        //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    /**
     * 从通道中读取数据到缓冲区
     *
     * @param key
     * @throws IOException
     */
    public static void handleRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if (bytesRead == -1) {
            sc.close();
        }
    }


    public static void selector() {
        try {
            while (true) {
                if (selector.select(5000) == 0) {
                    System.out.println("==");
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    System.out.println("就绪事件处理中===");
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    //这里需要手动从键集中移除当前的key
                    iter.remove();
                }
                System.out.println("就绪事件处理完成===");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) {
                    selector.close();
                }
                if (ssc != null) {
                    ssc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

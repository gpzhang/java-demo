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
 * 每一个channel只有一个selectKey生效
 * 服务端执行ServerSocketChannel ssc = ServerSocketChannel.open();创建一个服务端的管道，同时这个管道上会注册可接收连接请求的感兴趣事件
 * 服务端执行SocketChannel sc = ssChannel.accept();创建一个与客户端对应的管道，同时这个管道上会注册可读的感兴趣事件
 *
 * @author haishen
 * @date 2019/5/26
 */
public class ServerSocketChannelDemo {

    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8888;
    private static final int TIMEOUT = 3000;


    public static void main(String[] args) throws Exception {
        selector();
    }


    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        //调用了它的accept()方法 ,来获取刚到达的socket的句柄,返回的 对象的类型是SocketChannel
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
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
        System.out.print("serve 接收：");
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        /**
         * 当客户端主动切断连接的时候，服务端Socket的读事件（FD_READ）仍然起作用，
         * 也就是说，服务端Socket的状态仍然是有东西可读，当然此时读出来的字节肯定是 0。
         * socketChannel.read(buffer) 是有返回值的，这种情况下返回值是 -1，所以如果
         * read 方法返回的是 -1，就可以关闭和这个客户端的连接了。
         */
        if (bytesRead == -1) {
            sc.close();
        } else {
            // 向服务器发送消息
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String info = "reply information from serve to client";
            buffer.clear();
            buffer.put(info.getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                sc.write(buffer);
            }
        }

    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(PORT));
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                if (selector.select() == 0) {
                    System.out.println("==");
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    System.out.println("就绪事件处理中！！！");
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    //这里需要手动从键集中移除当前的key
                    iter.remove();
                }
                System.out.println("就绪事件处理完成！！！");
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

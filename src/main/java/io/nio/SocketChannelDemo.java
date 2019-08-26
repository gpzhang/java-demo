package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author haishen
 * @date 2019/5/26
 */
public class SocketChannelDemo {

    private Selector selector;

    public SocketChannelDemo init(String serverIp, int port) throws IOException {
        // 获取socket通道、
        // 在reactor模式中的资源
        SocketChannel channel = SocketChannel.open();
        // 将该通道设置为非阻塞
        channel.configureBlocking(false);
        // 获取多路复用器实例
        selector = Selector.open();
        // 客户端连接服务器，需要调用channel.finishConnect();才能实际完成连接。
        channel.connect(new InetSocketAddress(serverIp, port));
        // 为该通道注册SelectionKey.OP_CONNECT事件，也就是将channel的fd和感兴趣的事件添加到多路复用器中
        channel.register(selector, SelectionKey.OP_CONNECT);
        return this;
    }

    public void clientRun() throws IOException, InterruptedException {
        System.out.println("客户端启动");
        while (true) {
            selector.select();
            //获取注册在该复用器上的channel和channelEvent
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                SocketChannel channel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    // 如果正在连接，则完成连接
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    // 向服务器发送消息
                    // 向服务器发送消息
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    String info = "send information from client to serve";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        channel.write(buffer);
                    }
                    channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocateDirect(1024));
                }
                if (key.isReadable()) {

                    ByteBuffer buf = (ByteBuffer) key.attachment();
                    long bytesRead = channel.read(buf);
                    System.out.print("client 接收：");
                    while (bytesRead > 0) {
                        buf.flip();
                        while (buf.hasRemaining()) {
                            System.out.print((char) buf.get());
                        }
                        System.out.println();
                        buf.clear();
                        bytesRead = channel.read(buf);
                    }
                    if (bytesRead == -1) {
                        channel.close();
                    }

                    Thread.sleep(10 * 1000);
                    // 向服务器发送消息
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    String info = "reply information from client to server";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.println(buffer);
                        channel.write(buffer);
                    }
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {

        new SocketChannelDemo().init("127.0.0.1", 8888).clientRun();

    }


}

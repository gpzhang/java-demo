package io.bio;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * io  文件io、网络io
 *
 * @author haishen
 * @date 2019/5/26
 */
public class ServerDemo {
    private static boolean shutdown = false;

    public static void main(String[] args) {
        await();
    }

    public static void await() {
        ServerSocket serverSocket = null;
        int port = 8888;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;
            try {
                socket = serverSocket.accept();
                in = socket.getInputStream();
                out = socket.getOutputStream();
                //读取一行数据 
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                //输出打印
                String str = bufferedReader.readLine();
                System.out.println(str);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}

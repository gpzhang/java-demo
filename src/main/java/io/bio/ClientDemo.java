package io.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author haishen
 * @date 2019/5/26
 */
public class ClientDemo {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "hello,from client to socket server";
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author haishen
 * @date 2018/8/6
 */

public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream out;

    public Response(OutputStream out) {
        this.out = out;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    out.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found\n" +
                        "Content-Type:text/html\n" +
                        "Content-Length:23\n" +
                        "\n" +
                        "<h1>File not Found</h1>";
                out.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }
}

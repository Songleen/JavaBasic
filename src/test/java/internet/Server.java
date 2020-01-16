package internet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/17:19
 */
public class Server {

    @Test
    public void test1() throws IOException {
        ServerSocket server = new ServerSocket(8989);
        Socket socket = server.accept();
        System.out.println("一个客户端连接成功");

        InputStream input = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        byte[] data = new byte[1024];
        int len;
        while ((len = input.read(data)) != -1) {
            System.out.println(new String(data,0,len));
        }

        out.write("欢迎登陆啊啊啊啊！！！！！！！！".getBytes());

        socket.close();
        server.close();

    }
}

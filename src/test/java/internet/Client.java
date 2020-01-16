package internet;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/17:11
 */
public class Client {

    @Test
    public void test1() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8989);

            OutputStream out = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            //发送数据
            out.write("你好啊，会有乱码吗？".getBytes());
//            out.flush();
//            socket.shutdownOutput();
            System.out.println("数据已经上传完成");

            //接收数据
            byte[] data = new byte[6];
            int len;
            while ((len = input.read(data)) != -1) {
                System.out.println(new String(data,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭socket
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

package internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/21:56
 */
public class Practice01 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream out = null;
        InputStream input = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8000);
            out = socket.getOutputStream();
            input = socket.getInputStream();

            out.write("你好，我是客户端".getBytes());

            //read()方法是一个阻塞方法；客户端在写出数据之后，要调用下面这个方法，即“末尾标记”，
            // 对方才能读到-1，否则对方的读取会一直阻塞，但是阻塞只发生在客户端。
            socket.shutdownOutput();

            byte[] data = new byte[1024];
            int len;
            while ((len = input.read(data)) != -1) {
                String s = new String(data, 0, len);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream input = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();
            input = socket.getInputStream();
            out = socket.getOutputStream();

            //在UTF-8编码中，一个中文对应三个字节，所以下面这种情况会出现乱码
            /*byte[] data = new byte[5];
            int len;
            while ((len = input.read(data)) != -1) {
                String s = new String(data, 0, len);
                System.out.println(s);
            }*/

            //另一种避免乱码的方式,ByteArrayOutputStream会将字节拼起来整体输出
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int lenth;
            while ((lenth = input.read(bytes)) != -1) {
                baos.write(bytes,0,lenth);
            }
            System.out.println(baos.toString());
            out.write("数据接收完毕".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

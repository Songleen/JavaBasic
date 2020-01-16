package internet;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/26/9:00
 */
public class PracticeForUDP {

    @Test
    public void client() {
        DatagramSocket ds = null;
        try {
            //发送信息
            ds = new DatagramSocket();
            byte[] data = "hello,atguigu.com".getBytes(); //准备数据
            DatagramPacket dp = new DatagramPacket(data, 0, data.length,
                    InetAddress.getByName("127.0.0.1"), 1000); //封装数据，并指定位置
            ds.send(dp); //发送数据

            //接受确认信息
            byte[] comInfo = new byte[1024];
            dp.setData(comInfo, 0, comInfo.length);
            ds.receive(dp);
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println(s+"==="+dp.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }

    @Test
    public void server() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(1000);
            byte[] data = new byte[1024];
            DatagramPacket dp = new DatagramPacket(data, data.length);

            //接受数据
            ds.receive(dp);
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println(s+"==="+dp.getAddress());

            //发送确认信息
            byte[] comfirmInfo = "I have recieved your message,thank you".getBytes();
            dp.setData(comfirmInfo, 0, comfirmInfo.length);
            ds.send(dp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}

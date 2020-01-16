package internet;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/15:39
 */
public class testIpAndPort {

    @Test
    public void test1() throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        byte[] address = localHost.getAddress();
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        System.out.println("address==" + address + '\n' + "hostName===" + hostName + '\n' + "hostAddress===" + hostAddress);

        InetAddress byName = InetAddress.getByName("www.atguigu.com");
        System.out.println(byName);
        System.out.println(byName.getHostName());
        System.out.println(byName.getHostAddress());
        System.out.println("=====================");

    }
}

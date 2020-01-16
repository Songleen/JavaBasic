package internet;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/26/10:06
 */
public class PracticeForURL {

    @Test
    public void test1(){
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //建立连接
            URL url = new URL("http://localhost:8080/examples/beauty.jpg");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            //创建输入流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("today\\beauty3.jpg");

            //读取数据
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data))!=-1){
                fos.write(data,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

import com.carrotsearch.sizeof.RamUsageEstimator;
import sun.misc.Launcher;

import java.net.URL;
import java.util.HashMap;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/11/17 17:00
 */
public class Father {
    public void say() {
        System.out.println("这是父类的方法");
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("abc","哈哈啊哈");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}

class Son{
    Integer a;
}

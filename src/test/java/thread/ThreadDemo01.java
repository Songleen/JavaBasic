package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreadDemo01 {

    @Test
    public void test01() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("s","ab");

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bcdefg");
    }
}

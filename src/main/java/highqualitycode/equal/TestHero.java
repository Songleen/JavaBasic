package highqualitycode.equal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/15:53
 */
public class TestHero {

    @Test
    public void testHero() {
        Hero h1 = new Hero("张三");
        Hero h2 = new Hero(null);
        List<Hero> l = new ArrayList<>();
        l.add(h1);
        l.add(h2);
        System.out.println("列表中是否包含张三：" + l.contains(h1));
        boolean c = l.contains(h2);
        System.out.println("列表中是否包含张三：" + c);
    }

    @Test
    public void testCaptain() {
        Captain c1 = new Captain("李四", 100);
        Captain c2 = new Captain("李四", 1001);
        Hero h1 = new Hero("李四");
        boolean b1 = h1.equals(c1);
        boolean b2 = h1.equals(c2);
        boolean b3 = c1.equals(c2);
        System.out.println(b1+ "->" + b2 + "->" + b3);
    }

    @Test
    public void testEqualAndHashCode(){
        //Person类的实例作为Map的key
        Map<Hero, Object> map = new HashMap<Hero, Object>(){
            {
                put(new Hero("王五"), new Object());
            }
        };

        //Person类的实例作为List的元素
        List<Hero> list = new ArrayList<Hero>(){
            {
                add(new Hero("王五"));
            }
        };

        //列表中是否包含
        boolean b1 = list.contains(new Hero("王五"));
        //Map中是否包含
        boolean b2 = map.containsKey(new Hero("王五"));
        System.out.println(b1+"-->"+b2);
    }
}

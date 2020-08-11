package testEnum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/23/16:51
 */
public class EnumTest {

    @Test
    public void test01() {

        SeasonEnum season = null;
        switch (season) {
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎真好眠");
                break;
            default:
                System.out.println("兄弟，输入有错吧！！！");
        }

        SeasonEnum season2 = SeasonEnum.SPRING;
        season2.show();

    }

    @Test
    public void testArray() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("a", "abc");

    }

    public static void main(String[] args) {
        Map<String, Object> cmap = new ConcurrentHashMap<>(3);
        cmap.put("a", "abc");
    }
}

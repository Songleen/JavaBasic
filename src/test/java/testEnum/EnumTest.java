package testEnum;

import org.junit.Test;

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
}

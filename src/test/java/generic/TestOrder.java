package generic;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/25/10:19
 */
public class TestOrder {

    @Test
    public void test1(){
        Order o1 = new Order(); //如果实例化没有指明泛型类型，则认为此泛型类型为Object
        o1.setOrderT("这里被认为是Object"); //这里放入String类型
        o1.setOrderT(123); //这里添加int类型

        Order<String> o2 = new Order<>(); //指明了泛型类型
        o2.setOrderT("这里只能添加String类型");
    }

    @Test
    public void test2(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        order.copy(arr);
    }
}

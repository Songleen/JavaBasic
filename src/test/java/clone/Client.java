package clone;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/14:14
 */
public class Client {
    @Test
    public void test01() {
        Person f = new Person("父亲");
        Person s1 = new Person("大儿子", f);
        //小儿子的信息是通过大儿子拷贝过来的
        Person s2 = s1.clone();
        s2.setName("小儿子");
        s1.getFather().setName("干爹");
        System.out.println(s1.getName() + "的父亲是" + s1.getFather().getName());
        System.out.println(s2.getName() + "的父亲是" + s2.getFather().getName());
        System.out.println(s1.getFather() == s2.getFather());
    }

    @Test
    public void test02() {
        int a = 10;
        boolean b = whichBig(a);
        System.out.println(b);
    }

    private boolean whichBig(int a) {
        boolean result;
        try {
            int c = 10 / (a - 10);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Test
    public void test03() {
        BigDecimal result = BigDecimal.valueOf(0.1f);
        BigDecimal result2 = new BigDecimal(0.1);
        System.out.println(result);
        System.out.println(result2);
    }

}

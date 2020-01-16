package valueTransfer;

import org.junit.Test;

import java.io.PrintStream;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/31/15:28
 */
public class Practice {

    //理解变量的赋值
    @Test
    public void test1() {
        Order order1 = new Order();
        order1.setOrderId(1001);

        //将order1的地址值赋给order2，两个地址值相同
        Order order2 = order1;
        System.out.println(order2.getOrderId());

        order2.setOrderId(1002); //此时order1中的也变了，因为是同一个
        System.out.println(order1.getOrderId());
    }

    @Test
    public void test2() {
        int m = 10;
        int n = 20;
        Practice p = new Practice();
        p.changeValue(m, n);

        System.out.println(m + "===" + n);
    }

    private void changeValue(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
        System.out.println(m + "===" + n);
    }

    @Test
    public void test3() {
        int a = 10;
        int b = 10;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    /*private void method(int a, int b) {
        a = a * 10;
        b = b * 20;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(0);
    }*/

    private void method(int a ,int b){
        PrintStream ps = new PrintStream(System.out){

            //这地方是改变了上面的输出流，当走到打印那儿的时候，会进入到
            //这里面来。
            @Override
            public void println(String x) {
                if ("a=10".equals(x)){
                    x="a=100";
                }else if ("b=10".equals(x)){
                    x="b=200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}

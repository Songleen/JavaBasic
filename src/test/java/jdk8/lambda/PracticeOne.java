package jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/29/17:39
 */
public class PracticeOne {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!!!");
            }
        };
        r1.run();

        System.out.println("********************");

        Runnable r2 = () -> System.out.println("hello world!!!");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        //Lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare = com2.compare(23, 10);
        System.out.println(compare);

        //方法引用
        Comparator<Integer> com3 = Integer::compareTo;
        System.out.println(com3.compare(23, 10));
    }

    @Test
    public void test3() {
        Consumer<String> cons = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        cons.accept("你好，这是一个接口的匿名实现类的对象！！！");
        System.out.println("===================");

        Consumer<String> cons1 = s -> System.out.println(s);
        cons1.accept("这是用Lambda表达式写的！！！");

        Consumer<String> cons2 = System.out::print;
        cons2.accept("这是方法引用写的！！！");
    }

    @Test
    public void test4() {
        Supplier<String> supp = new Supplier<String>() {
            @Override
            public String get() {
                return "你好，这是返回给你的数据";
            }
        };
        System.out.println(supp.get());

        Supplier<String> supp2 = () -> "你好，这是返回的数据,真是神奇啊！！！！";
        System.out.println(supp2.get());
    }

    @Test
    public void test5() {
        Function<String, String> fun = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "你传给我的参数是" + s;
            }
        };
        System.out.println(fun.apply("Songleen"));

        Function<String, String> fun2 = s -> s;
        String penny = fun2.apply("Penny");
        System.out.println("这次你传进来的参数是"+penny);
    }

    @Test
    public void test6(){
        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.contains("A")){
                    return true;
                }
                return false;
            }
        };
        System.out.println(pre.test("aAc"));

        //如果Lambda方法体不止一行，大括号就不能省略
        Predicate<String> pre2 = s -> {
            if (s.contains("B")){
                return true;
            }
            return false;
        };

        System.out.println(pre2.test("abB"));
    }

    @Test
    public void test7(){
        BiFunction<String,String,String> bif = new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                if (s.contains(s2)){
                    return s+"是"+s2+"大哥";
                }
                return s+"不是"+s2+"大哥";
            }
        };
        System.out.println(bif.apply("我是你大哥", "大哥"));

        BiFunction<String,String,String> bi2 = (s,s1)->{
            if (s.contains(s1)){
                return s+"是"+s1+"大哥";
            }
            return s+"不是"+s1+"大哥";
        };
        System.out.println(bi2.apply("许文强", "丁力"));
    }

    @Test
    public void test8(){
        int a = 10;
        int i = a++;
        System.out.println(i);
        System.out.println(a);

        int b = 10;
        int j = ++b;
        System.out.println(j);
        System.out.println(b);
    }
}

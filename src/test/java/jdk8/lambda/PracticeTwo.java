package jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/12/18/14:05
 */
public class PracticeTwo {

    @Test
    public void test1() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.equals("abcd")) {
                    System.out.println("输入的是abc");
                    return;
                }
                System.out.println("输入的不是abcd");
                return;
            }
        };
        consumer.accept("abc");
    }

    @Test
    public void test1Lambda() {
        Consumer<String> c = s -> {
            if ("abcd".equals(s)) {
                System.out.println("输入的是abcd");
                return;
            }
            System.out.println("输入的不是abcd");
        };
        c.accept("abc");
    }

    @Test
    public void test2() {
        Supplier<String> result = new Supplier<String>() {
            @Override
            public String get() {
                return "不用给我什么，我给你";
            }
        };
        System.out.println(result.get());
    }

    @Test
    public void test2Lambda() {
        Supplier<String> result = () -> "不用给我什么，我给你就好";
        System.out.println(result.get());
    }

    @Test
    public void test3() {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                if (s.equals("a")) {
                    return 27;
                }
                if (s.equals("b")) {
                    return 28;
                }
                return 100;
            }
        };
        System.out.println(function.apply("c"));
    }

    @Test
    public void test3Lambda() {
        Function<String, Object> function = s -> {
            if (s.equals("a")) {
                return 27;
            }
            if (s.equals("b")) {
                return 28;
            }
            return 100;
        };
        System.out.println(function.apply("b"));
    }

    @Test
    public void test4() {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer s) {
                if (s >= 10) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(predicate.test(3));
    }

    @Test
    public void test4Lambda() {
        Predicate<Integer> predicate = s -> s >= 10;
        System.out.println(predicate.test(15));
    }
}

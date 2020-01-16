package jdk8.stream;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/12/18/17:50
 */
public class PracticeTwo {

    @Test
    public void test1(){
        List<Integer> integers = new ArrayList<>();
        Stream<Integer> parallelStream = integers.parallelStream();
        Stream<Integer> stream = integers.stream();
    }

    @Test
    public void test2(){
        Stream<Integer> iterate = Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        });
        iterate.limit(10).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void test2Lambda(){
        Stream.iterate(0, s->s+2).limit(10).forEach(s-> System.out.println(s));
    }


}

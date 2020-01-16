package collection;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/24/16:12
 */
public class TestListAndSet {

    @Test
    public void test1(){
        ArrayList<String> arr = new ArrayList<>();

        arr.add("abc");
        System.out.println(arr.get(0));

        int i1 = arr.hashCode();
        System.out.println(i1);

        arr.add("bcd");
        System.out.println(arr.hashCode());


    }
}

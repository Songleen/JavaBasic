package testArray;

import org.junit.Test;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/24/20:57
 */
public class TestArray {

    @Test
    public void test1(){
        int[] array = new int[4];
        array[0] = 1;
        array[1] = 2;
        System.out.println(array.length);
        System.out.println(array[2]);
    }
}

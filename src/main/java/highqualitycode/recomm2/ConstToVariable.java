package highqualitycode.recomm2;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/06/9:44
 */

interface Const{
    int RAND_CONST = new Random().nextInt();
}

public class ConstToVariable {

    @Test
    public void test01(){
        System.out.println("常量变了吗："+Const.RAND_CONST);
    }
}

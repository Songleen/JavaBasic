package reflection.practiceForStaticProxy;

import org.junit.Test;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/8:41
 */
public class TestStaticProxy {

    @Test
    public void test1(){
        Person person = new Person();
        PersonProxy proxy = new PersonProxy(person);
        proxy.eat();
    }
}

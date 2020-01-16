package clone;

import org.junit.Test;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/14:14
 */
public class Client {
    @Test
    public void test01(){
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
}

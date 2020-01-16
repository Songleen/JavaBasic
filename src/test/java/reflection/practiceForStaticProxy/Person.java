package reflection.practiceForStaticProxy;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/8:37
 *
 * 被代理类
 */
public class Person implements Biology {
    @Override
    public void eat() {
        System.out.println("人要吃饭！！");
    }
}

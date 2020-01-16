package reflection.practiceForStaticProxy;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/8:38
 *
 * 代理类，也需要实现接口，并\聚合被代理类
 */
public class PersonProxy implements Biology {

    private Biology person;

    public PersonProxy(Biology person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("吃东西之前先喝汤！！");
        person.eat();
        System.out.println("吃完东西之后别忘了吃点水果！！！");
    }
}

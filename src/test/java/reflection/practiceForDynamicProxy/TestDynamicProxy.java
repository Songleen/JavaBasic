package reflection.practiceForDynamicProxy;

import org.junit.Test;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/10:45
 */
public class TestDynamicProxy {

    @Test
    public void test1(){
        Dog dog = new Dog();
        Animal animal = (Animal) ProxyClassFactory.getProxyInstance(dog);

        String eat = animal.eat();
        System.out.println(eat);
        animal.sleep("趴着");

        Cat cat = new Cat();
        Animal catProxy = (Animal) ProxyClassFactory.getProxyInstance(cat);
        System.out.println(catProxy.eat());
        catProxy.sleep("窝着");
    }

    @Test
    public void test2(){
        Superman superman = new Superman();
        Human humanProxy = (Human) ProxyClassFactory.getProxyInstance(superman);
        humanProxy.fly();
    }
}

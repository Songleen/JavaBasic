package reflection.practiceForDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/8:59
 *
 * 代理类工程，根据被代理类生成一个代理类对象
 *
 * 想要实现动态代理，需要的解决的问题：
 *  1、如何根据被加载到内存中的被代理类，动态创建一个代理类及其对象；
 *  2、当通过代理类对象调用方法时，如何动态调用被代理类中的同名方法。
 */
public class ProxyClassFactory{

    public static Object getProxyInstance(Object obj){
        MyInvocationHandler myHandler = new MyInvocationHandler();
        myHandler.bind(obj);

        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), myHandler);
        return o;
    }

}

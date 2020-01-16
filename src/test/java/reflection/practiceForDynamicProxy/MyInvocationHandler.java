package reflection.practiceForDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/10:31
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当通过代理类调用方法时，就会自动调用如下方法
    //将被代理类要执行的方法功能声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object returnValue = null;
        if (method.getName().equals("sleep")){
            System.out.println("狗先看家再睡觉");
            returnValue = method.invoke(obj, args);
            return returnValue;
        }
        if (method.getName().equals("fly")){
            System.out.println("超人有超能力！！！");
            returnValue = method.invoke(obj, args);
            return returnValue;
        }
        returnValue = method.invoke(obj, args);
        return returnValue;
    }
}

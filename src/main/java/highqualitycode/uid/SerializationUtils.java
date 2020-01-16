package highqualitycode.uid;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/06/10:45
 */
public class SerializationUtils {
    private static String FILE_NAME = "E:/obj.bin";

    //序列化
    public static void writeObject(Serializable s) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    public static Object readObject() {
        Object o = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_NAME));) {
            o = input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Test
    public void test01() {
        B.s.doSomething();
    }

    @Test
    public void test02() {
        Server s = new SimplleServer(1000);

    }

    @Test
    public void test03() {
        D d = new D();
    }

    @Test
    public void test04() {
        SimplleServer s = new SimplleServer(1000);
    }

    @Test
    public void test05() {
        Calculator c = new Calculator(2,3);
        c.setOperator(Ops.ADD);
        System.out.println("常规操作："+c.getResult());
        Calculator c1 = new Calculator(1,2){
            {
                setOperator(Ops.ADD);
            }
        };
        System.out.println("骚操作："+c1.getResult());

    }
    @Test
    public void test06(){
        Add add = new Add(1, 2);
        int result = add.getResult();
        System.out.println(result);
    }
}

interface S {
    public void doSomething();
}

//接口中存在实例代码
interface B {
    public static final S s = new S() {
        @Override
        public void doSomething() {
            System.out.println("我在接口中实现了！！");
        }
    };
}

abstract class Server {
    public final static int DEFAULT_PORT = 40000;

    public Server() {
        //获取子类提供的端口号
        int port = getPort();
        System.out.println("端口号：" + port);
    }

    protected abstract int getPort();
}

class SimplleServer extends Server {
    private int port = 100;

    //初始化传递一个端口号
    public SimplleServer(int _port) {
        port = _port;
    }

    @Override
    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}

class C {
    private String g = "abc";
    private int e;

    public C() {
        System.out.println("父类无参构造" + e);
    }

    public C(int a) {
        System.out.println("父类有参构造");
    }

    static {
        int h = 109;
    }

    {
        int i = 110;
    }
}

class D extends C {
    private int c = 200;

    public D() {
        System.out.println("子类无参构造" + c);
    }

    public D(int b) {
        System.out.println("子类有参构造" + b);
    }

    static {
        int q = 123;
    }

    {
        int w = 234;
    }
}

enum Ops {ADD, SUB}

class Calculator {
    private int i, j, result;

    public Calculator() {
    }

    public Calculator(int _i,int _j){
        i = _i;
        j = _j;
    }
    protected void setOperator(Ops _op){
        result = _op.equals(Ops.ADD)?i+j:i-j;
    }
    public int getResult(){
        return result;
    }
}

class Add extends Calculator{
    {
        setOperator(Ops.ADD);
    }
    //覆写父类的构造方法
    public Add(int _i,int _j){
    }
}




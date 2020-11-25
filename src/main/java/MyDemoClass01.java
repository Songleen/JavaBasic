import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/8/11 16:01
 */
public class MyDemoClass01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class MyThread extends Thread {
    private static Map map = new ConcurrentHashMap<String, Object>();
    private static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        map.put("a"+Thread.currentThread(), "a");
        System.out.println("这是线程：" + Thread.currentThread().getName());
        lock.unlock();
    }
}

package reflection.practiceOne;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/26/10:56
 */
public class PracticeOne {

    @Test
    public void test1() throws NoSuchMethodException {
        Teacher chinese = new Teacher("语文老师", 28);

        //这里就找到了这个对象对应的类
        Class<? extends Teacher> clazz = chinese.getClass();
        System.out.println(clazz);

        //通过类获取到类中的成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("==========");
        Field[] fields1 = clazz.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        Method teach = clazz.getMethod("teach");
        System.out.println(teach);
    }

    @Test
    public void test2() throws Exception {
        //1、利用反射创建对象
        // Student.class表示的其实还是类本身，它是Class类的一个实例,所以类也是一个对象
        Class<Student> clazz = Student.class;
        Constructor<Student> cons = clazz.getConstructor(String.class, int.class);
        Student stu = cons.newInstance("小学生", 12);
        System.out.println(stu);

        //2、通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true); //设置为true后才能更改私有属性，否则会报错
        age.set(stu, 8);
        System.out.println(stu.toString());

        //3、通过反射调用方法
        Method study = clazz.getDeclaredMethod("study");
        study.invoke(stu);
    }

    @Test
    public void test3() {
        //获取到了系统类加载器，最常用
        ClassLoader classLoader = PracticeOne.class.getClassLoader();
        System.out.println(classLoader);

        //获取到了扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //获取引导类加载器,用来加载java核心库，无法直接获取
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    @Test
    public void test4() throws Exception {

        Properties p = new Properties();

        //方式一读取properties配置文件,此时配置文件默认在工程目录下,放在resource下也不行
        //但是此种情况部署到服务器上之后就会缺失
        FileInputStream fis = new FileInputStream("index.properties");
        p.load(fis);

        String user = p.getProperty("user");
        String age = p.getProperty("age");
        System.out.println(user + "======" + age);

        //方式二读取properties配置文件,此时配置文件默认在resource目录下
        ClassLoader classLoader = PracticeOne.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        p.load(is);

        String user1 = p.getProperty("user");
        String age1 = p.getProperty("age");
        System.out.println(user1 + "========" + age1);
    }

    @Test
    public void test5() throws Exception {

        Class<Student> clazz = Student.class;

        //本质上创建对象都需要调用构造器，这里默认调用空参构造器
        //且空参构造器不能私有
        Student s = clazz.newInstance();
        System.out.println(s);
    }


    //体会反射的动态性,即只有在运行的时候才知道要创建的是哪个对象
    @Test
    public void test6() throws Exception {
        for (int i = 0; i < 30; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "java.util.Date";
                    break;
                case 0:
                    classPath = "reflection.practiceOne.Student";
                    break;
            }
            Object o = getInstance(classPath);
            System.out.println(o);
        }
    }


    private Object getInstance(String path) throws Exception {
        Class clazz = Class.forName(path);
        Object o = clazz.newInstance();
        return o;
    }

    @Test
    public void test7() throws Exception {
        Class<Student> clazz = Student.class;
        Student s = clazz.newInstance();

        Field name = clazz.getDeclaredField("studentName");
        //保证当前属性是可访问的
        name.setAccessible(true);
        name.set(s, "小强");
        System.out.println(s.getStudentName());

    }

    @Test
    public void test8() throws Exception {
        Class<Student> clazz = Student.class;
        Student s = clazz.newInstance();

        Method study1 = clazz.getDeclaredMethod("study");
        study1.setAccessible(true);
        study1.invoke(s);

        Method selfStudy = clazz.getDeclaredMethod("selfStudy", String.class);
        selfStudy.invoke(null, "小静态");
        selfStudy.invoke(Student.class, "小小静态");
    }

    @Test
    public void test9() throws Exception {
        Class clazz =  Class.forName("reflection.practiceOne.Header");
        Object o = clazz.newInstance();
        System.out.println(o);
    }
}



package highqualitycode.uid;

import org.junit.Test;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/06/10:54
 */
public class TestSerialization {

    @Test
    public void testProducer() {
        Student student = new Student("小张", 13);
        student.setAge(44);
        SerializationUtils.writeObject(student);
    }

    @Test
    public void testConsumer() {
        Student o = (Student) SerializationUtils.readObject();
        System.out.println(o.getName());
        System.out.println(o.getAge());

    }

    @Test
    public void test3() {
        int a = 11;
        Integer c = Integer.valueOf(a);
        int b = 129;
        System.out.println(b);
        System.out.println(c);
    }
}

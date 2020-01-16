package string;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/22/9:38
 */
public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        if (o instanceof Person) {
            return Integer.compare(o.getAge(), this.age);
        }
        throw new RuntimeException("输入的对象不正确");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj.getClass()!=obj.getClass()){
            return false;
        }
        Person p = (Person) obj;
        //根据名字判断是否相等
        if (this.name == p.getName()){
            return true;
        }
        return false;
    }

}

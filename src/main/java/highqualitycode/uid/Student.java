package highqualitycode.uid;

import java.io.Serializable;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/06/10:42
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 5553L;

    private String name;
    private Integer age;
    private Integer id;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

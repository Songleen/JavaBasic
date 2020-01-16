package clone;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/07/14:06
 */
public class Person implements Cloneable {
    private String name;
    private Person father;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person father) {
        this.name = name;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    protected Person clone() {
        Person p = null;
        try {
            p = (Person) super.clone();
            p.setFather(new Person(p.getFather().getName()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}


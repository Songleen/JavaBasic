package reflection.practiceOne;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/26/11:02
 */
public class Student {
    private String studentName;
    private int age;

    public Student() {
    }

    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public void study(String studentName){
        System.out.println(studentName+"学生的职责是学习");
    }

    public static void selfStudy(String studentName){
        System.out.println(studentName+"应该养成自我学习的习惯");
    }

    private void study(){
        System.out.println("这是一个私有方法");
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}

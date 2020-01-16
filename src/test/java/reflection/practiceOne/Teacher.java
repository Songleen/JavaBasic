package reflection.practiceOne;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/26/11:03
 */
public class Teacher {
    private String teacherName;
    private int teacherAge;
    public String email;

    public Teacher(String teacherName, int teacherAge) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
    }

    public void teach(){
        System.out.println("老师的工作是教书！！！");
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }
}

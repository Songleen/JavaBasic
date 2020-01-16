package reflection.practiceForDynamicProxy;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/8:57
 */
public class Dog implements Animal {

    @Override
    public String eat() {
        return "狗吃肉！！";
    }

    @Override
    public void sleep(String posture) {
        System.out.println("狗一般"+posture+"睡觉！！！");
    }
}

package reflection.practiceForDynamicProxy;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/11:01
 */
public class Cat implements Animal {
    @Override
    public String eat() {
        return "猫吃鱼";
    }

    @Override
    public void sleep(String posture) {
        System.out.println("猫一般"+posture+"睡觉!!");
    }
}

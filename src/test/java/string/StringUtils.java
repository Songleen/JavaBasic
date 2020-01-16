package string;

/**
 * 测试String的replaceAll和replace的参数区别
 *
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/08/9:14
 */
public class StringUtils {

    //删除字符串,replaceAll第一个参数是正则表达式
    public static String remove(String source,String sub){
        return source.replaceAll(sub, "");
    }
}

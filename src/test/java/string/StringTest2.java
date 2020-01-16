package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * 测试String的replace方法的参数
 *
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2020/01/08/9:17
 */
public class StringTest2 {

    @Test
    public void test01() {
        assertTrue(StringUtils.remove("好是好", "好").equals("是"));
    }

    @Test
    public void test02() {
        assertTrue(StringUtils.remove("$是$", "$").equals("是"));
    }

    @Test
    public void test03() {
        String str = "abc";
        String str1 = new String(str);
        String str2 = str.substring(0) + "d";
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));

    }

    @Test
    public void test04() throws UnsupportedEncodingException {
        String str = "汉字";
        byte[] b = str.getBytes("GBK");
        System.out.println(new String(b));

    }

    @Test
    public void test05() {
        Integer[] data = {1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
        System.out.println(data.equals(list.get(0)));
    }

    @Test
    public void test06() {
        List<String> strs = new ArrayList<>();
        strs.add("A");
        strs.add("B");
        strs.add("C");
        List<String> strs1 = new ArrayList<>(strs);
        List<String> strs2 = strs.subList(0, strs.size());
        strs2.add("D");
        System.out.println(strs.equals(strs1));
        System.out.println(strs.equals(strs2));
    }

    @Test
    public void test07(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("关羽",20));
        list.add(new Person("关羽",18));
        Collections.sort(list);

        Person person = new Person("关羽", 18);
        int index1 = list.indexOf(person);
        int index2 = Collections.binarySearch(list, person);
        System.out.println(index1);
        System.out.println(index2);
    }

    @Test
    public void test08(){
        List<String> list = new ArrayList<>();
        list.add("曹操");
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        list.add("赵云");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void test09(){
        Stack<String> stack = new Stack<>();
        stack.push("关羽");
        stack.push("张飞");
        stack.push("赵云");
        String pop = stack.pop();
        System.out.println(pop);
    }

}

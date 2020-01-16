package comparable;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/31/13:47
 */
public class Practice {

    @Test
    public void test1(){

        //像String、包装类等实现了Comparable接口，重写了compareTo()方法，进行了从小到大的排列
        String[] arr = new String[]{"AA", "CC", "KK", "GG", "JJ", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //自定义商品类进行排序
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("西瓜",24);
        goods[1] = new Goods("芒果",54);
        goods[2] = new Goods("樱桃",34);
        goods[3] = new Goods("石榴",27);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}

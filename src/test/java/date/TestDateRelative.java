package date;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/11/17/21:52
 */
public class TestDateRelative {

    @Test
    public void test1(){
        String str = "119933-09-08";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(str, new ParsePosition(3));
        System.out.println(parse);
    }

    @Test
    public void test2(){
        int dayOfMonth = Calendar.DAY_OF_MONTH;
        System.out.println(dayOfMonth);
    }
}

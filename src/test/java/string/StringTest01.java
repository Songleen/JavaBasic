package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/22/8:42
 */
public class StringTest01 {

    @Test
    public void test01() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);   //true
        String str3 = new String(str2);
        System.out.println(str2 == str3);   //false
    }

    @Test
    public void test02() {
        String str4 = "abc";
        String str5 = str4.replace('a', 'f');
        System.out.println(str4);
        System.out.println(str5);

    }

    @Test
    public void test03() {
        Person p1 = new Person("Tom", 18);
        Person p2 = new Person("Tom", 18);
        System.out.println(p1.name == p2.name);
        System.out.println(p1.age == p2.age);
    }

    @Test
    public void test04() throws UnsupportedEncodingException {
        String str = "a";
        String str2 = "c";

        int i = str.compareTo(str2);
        System.out.println(i);

    }

    @Test
    public void test05() {
        StringBuffer b1 = new StringBuffer("我喜欢书序");
        b1.setCharAt(2, 'z');
        System.out.println(b1);
    }

    @Test
    public void test06() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        Date date1 = new Date(1571727598531L);
        System.out.println(date1);
    }

    @Test
    public void test07() {
        //创建java.sql.Date对象,只有这一个构造没有过时
        java.sql.Date date = new java.sql.Date(283978284924L);

        //将java.util.Date对象转换成java.sql.Date对象
        //方式一：多态方式
        Date date1 = new java.sql.Date(3827467174671L);
        java.sql.Date date2 = (java.sql.Date) date1;

        //方式二
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
    }

    @Test
    public void test08() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println(format.format(date));

        String str = "1993-12-18 上午 18:25";
        Date parse = format.parse(str);
        System.out.println(parse);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        String format2 = format1.format(date);
        System.out.println("format2======" + format2);

        Date date2 = null;
        try {
            date2 = format1.parse("2008年08月08日 星期一 08:08:08");
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test09() {
        Calendar c = Calendar.getInstance();    //获取对象

        TimeZone timeZone = c.getTimeZone();  //获取时区
        Date time = c.getTime(); // 获取期望的日历日期
        long timeInMillis = c.getTimeInMillis(); //功能与System.currentTimeMillis()等效
        String calendarType = c.getCalendarType();
        c.set(Calendar.DAY_OF_MONTH, 8); //设置某个字段的值
        c.add(Calendar.HOUR, 24); //在当前时间加24小时，改变了天的数量
        c.roll(Calendar.MINUTE, 23); //在当前日历时间增加分钟数，但不改变小时的量
    }

    @Test
    public void test10() {
        //ZoneId：类中包含了所有时区的信息
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zoneId : zoneIds) {
            System.out.println(zoneId);
        }

        //获取指定时区的时间
        LocalDateTime lo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(lo);

        //带时区的日期时间
        ZonedDateTime zone = ZonedDateTime.now();
        System.out.println(zone);

        //指定时区的日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);
    }

    @Test
    public void test11() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(10, 40, 00);
        Duration duration = Duration.between(localTime, localTime1);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());
        System.out.println(duration.toDays());

        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
        Duration duration1 = Duration.between(localDateTime1, localDateTime);
        System.out.println(duration1.toDays());
    }

    @Test
    public void test12(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void test13(){
        Person person = new Person();
        String s = person.toString();

        System.out.println(person.toString());
    }

    @Test
    public void test14() throws UnsupportedEncodingException {
        String str = "中";
        byte[] bytes = str.getBytes();
        System.out.println(bytes);
        System.out.println(bytes.length);

        String s = new String(bytes);
        System.out.println(s);
    }
}

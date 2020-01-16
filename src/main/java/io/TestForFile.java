package io;

import org.junit.Test;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/16:35
 */
public class TestForFile {

    @Test
    public void test1() {
        File file = new File("hello.txt");
    }

    @Test
    public void test2() {
        LocalDateTime d1 = LocalDateTime.of(2019, 11, 5, 8, 8, 8);
        LocalDateTime d2 = LocalDateTime.of(2019, 11, 4, 18, 8, 8);
        LocalDateTime d3 = LocalDateTime.of(2019, 11, 5, 12, 8, 8);
        LocalDateTime d4 = LocalDateTime.of(2019, 11, 4, 7, 58, 8);
        LocalDateTime d5 = LocalDateTime.of(2019, 11, 4, 17, 8, 28);
        LocalDateTime d6 = LocalDateTime.of(2019, 11, 5, 23, 18, 48);
        LocalDateTime d7 = LocalDateTime.of(2019, 11, 4, 18, 38, 28);
        Date t1 = Timestamp.valueOf(d1);
        Date t2 = Timestamp.valueOf(d2);
        Date t3 = Timestamp.valueOf(d3);
        Date t4 = Timestamp.valueOf(d4);
        Date t5 = Timestamp.valueOf(d5);
        Date t6 = Timestamp.valueOf(d6);
        Date t7 = Timestamp.valueOf(d7);
        Map<String, Object> temp1 = new HashMap<>();
        Map<String, Object> temp2 = new HashMap<>();
        Map<String, Object> temp3 = new HashMap<>();
        Map<String, Object> temp4 = new HashMap<>();
        Map<String, Object> temp5 = new HashMap<>();
        Map<String, Object> temp6 = new HashMap<>();
        Map<String, Object> temp7 = new HashMap<>();
        temp1.put("date", t1);
        temp2.put("date", t2);
        temp3.put("date", t3);
        temp4.put("date", t4);
        temp5.put("date", t5);
        temp6.put("date", t6);
        temp7.put("date", t7);
        List<Map<String, Object>> maps = new ArrayList<>();
        maps.add(temp1);
        maps.add(temp2);
        maps.add(temp3);
        maps.add(temp4);
        maps.add(temp5);
        maps.add(temp6);
        maps.add(temp7);
        List<Map<String, Object>> maps2 = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            if (maps2.size() == 0) {
                maps2.add(map);
            } else {
                boolean find = false;
                for (Map<String, Object> resultMap : maps2) {
                    String stringDate = String.valueOf(map.get("date"));
                    String resultDate = String.valueOf(resultMap.get("date"));
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;
                    Date stringResultDate = null;

                    try {
                        date = format.parse(stringDate);
                        stringResultDate = format.parse(resultDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    //如果日期部分相同，比较时间部分
                    if (date.equals(stringResultDate)) {
                        find = true;
                        Date date2 = null;
                        Date stringResultDate2 = null;
                        try {
                            date2 = format2.parse(stringDate);
                            stringResultDate2 = format2.parse(resultDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date2.after(stringResultDate2)) {
                            maps2.remove(resultMap);
                            maps2.add(map);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                //如果里面没有一样的，直接放进去
                if (!find) {
                    maps2.add(map);
                }
            }
        }
        System.out.println(maps2);
    }
}

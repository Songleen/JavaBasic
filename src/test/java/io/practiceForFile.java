package io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName JavaBasic
 * @Author Songleen
 * @Date 2019/10/28/16:17
 */
public class practiceForFile {

    @Test
    public void test1() {
        File file2 = new File("hello.txt");
        File file = new File("G:\\atguigu\\info.txt");
        File file1 = new File("G:" + File.separator + "atguigu" + File.separator + "infomation.txt");
    }

    @Test
    public void test2() throws Exception {
        File intFile = new File("aaa.txt");
        File outFile = new File("bbb.txt");

        /*FileInputStream fileInputStream = new FileInputStream(intFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);*/

        BufferedReader br = new BufferedReader(new FileReader(intFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));

        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str + "\n");
        }

        br.close();
        bw.close();
    }

    @Test
    public void test4() throws Exception {
        File intFile = new File("F:\\印度项目相关资料\\view.m2t");
        File outFile = new File("F:\\印度项目相关资料\\view1.m2t");

        FileInputStream fileInputStream = new FileInputStream(intFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);

        long l = System.currentTimeMillis();
        System.out.println(l);

        byte[] bytes = new byte[8192];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        fileOutputStream.close();
        fileInputStream.close();
        System.out.println(System.currentTimeMillis() - l);
    }

    @Test
    public void test3() throws Exception {
        File intFile = new File("ccc.txt");
        File outFile = new File("ddd.txt");

        FileInputStream is = new FileInputStream(intFile);
        FileOutputStream out = new FileOutputStream(outFile);

        byte[] bytes = new byte[5];
        int len;
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
            out.write(bytes, 0, len);
        }
        out.close();
        is.close();
    }

    @Test
    public void test5() throws Exception {
        InputStreamReader is = new InputStreamReader(new FileInputStream
                (new File("aaa.txt")), "UTF-8"); //这里的编码应该是文件本来的编码,否则读进来就是乱码
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream
                (new File("bbb.txt")), "GBK");

        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(os);

        String str = null;
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    @Test
    public void test6() throws Exception {
        System.out.println("请输入信息：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = br.readLine()) != null) {
            if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                System.out.println("安全退出！！");
                break;
            }
            System.out.println("--->" + s.toUpperCase());
            System.out.println("继续输入信息");
        }

        br.close();
    }

    @Test
    public void test7() throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("G:\\text.txt"));
        PrintStream ps = new PrintStream(fos);

        if (ps != null) {
            System.setOut(ps);
        }

        for (int i = 0; i <= 255; i++) { //输出ASCII字符
            System.out.print((char) i);
            if (i % 50 == 0) {   //每50个数据一行
                System.out.println();
            }
        }
    }

}

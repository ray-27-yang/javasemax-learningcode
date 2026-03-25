package TimeTest;

import java.io.*;

public class demo1 {
    private static final String SRCPath = "C:\\Users\\20691\\Desktop\\电吉他\\Given.mp4";
    private static final String DESTPath = "C:\\Users\\20691\\Desktop\\电吉他";

    public static void main(String[] args) {
        //非常慢，直接淘汰
        //copyFile1();
        copyFile2();//5.727ms
        //copyFile3();//3.512ms
        copyFile4();//0.862ms
    }

    //低级字节流按照一个一个字节形式复制文件：
    public static void copyFile1() {
        //拿系统当前时间          (这个时间是纪念C语言的诞辰)
        //拿到此刻一个时间毫秒值：从1970年1月1日0时0分0秒0毫秒开始走到此刻的时间毫秒值 1s = 1000ms
        long start = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(SRCPath);
                OutputStream out = new FileOutputStream(DESTPath + "Given-copy1.mp4");
        ) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级字节流按照一个一个字节形式复制文件耗时：" + (end - start) / 1000.0 + "ms");
    }

    //低级字节流按照字节数组形式复制文件
    public static void copyFile2() {
        long start = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(SRCPath);
                OutputStream out = new FileOutputStream(DESTPath + "Given-copy2.mp4");
        ) {
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级字节流按照字节数组形式复制文件耗时：" + (end - start) / 1000.0 + "ms");
    }

    //高级字节流按照字节一个个字节形式复制文件
    public static void copyFile3() {
        long start = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(SRCPath);
                OutputStream out = new FileOutputStream(DESTPath + "Given-copy3.mp4");
                //把低级字节输入流包装成高级字节输入流
                InputStream in1 = new BufferedInputStream(in);
                //把低级字节输出流包装成高级字节输出流
                OutputStream out1 = new BufferedOutputStream(out);
        ) {
            int b;
            while ((b = in1.read()) != -1) {
                out1.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级字节流按照字节一个个字节形式复制文件耗时：" + (end - start) / 1000.0 + "ms");
    }

    //高级字节流按照字节数组形式复制文件
    public static void copyFile4() {
        long start = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(SRCPath);
                InputStream in1 = new BufferedInputStream(in);
                OutputStream out = new FileOutputStream(DESTPath + "Given-copy4.mp4");
                OutputStream out1 = new BufferedOutputStream(out);

        ) {
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = in1.read(buffer)) != -1) {
                out1.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级缓冲字节流按照字节数组形式复制文件耗时：" + (end - start) / 1000.0 + "ms");
    }
}

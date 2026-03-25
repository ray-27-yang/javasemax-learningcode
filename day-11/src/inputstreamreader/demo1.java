package inputstreamreader;

import java.io.*;

public class demo1 {
    public static void main(String[] args) {
        //目标：用字符输入转换流解决不同编码读取断码的问题
        try (
                //先提取GBK文件的原始字节流
                InputStream is = new FileInputStream("day-10\\src\\demo3");
                //指定编码把字节流转换成字符输入流
                Reader isr = new InputStreamReader(is,"GBK");
                //创建一个字符缓冲输入流与字符输入流接通
                BufferedReader br = new BufferedReader(isr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

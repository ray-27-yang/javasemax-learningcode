package buffereddemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        //出师表案列
        try (
                //创建字符输入流管道
                Reader in = new FileReader("day-10\\src\\buffereddemo\\csb.txt");
                BufferedReader br = new BufferedReader(in);
                //创建字符输出流管道
                Writer out = new FileWriter("day-10\\src\\buffereddemo\\csb-out.txt");
                BufferedWriter bw = new BufferedWriter(out);
        ){
            //2.定义一个集合装载数据
            List<String> data = new ArrayList<>();
            //3.读取数据到集合
            String line;
            while ((line = br.readLine()) != null){
                data.add(line);
            }
            //4.给集合中的每段内容按照首字母排序,默认可排，后面的排序规则可省略
            Collections.sort(data,(o1, o2)->o1.charAt(0) - o2.charAt(0));
            System.out.println(data);
            //5.将集合中的数据写入到文件
            for (String l : data) {
                bw.write(l);
                bw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

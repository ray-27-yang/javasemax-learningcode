package com.fei.demo1;

public class StringUtil {
    //方法1.打印名字总长度2.得到字符串最大索引
    public static void printNameLength(String name) {
        if (name == null||"".equals(name)){
            System.out.println("请输入正确的名字");
            return;
        }
        System.out.println(name.length());
    }
    public static int getMaxIndex(String name) {
        if (name == null||"".equals(name)){
            return -1;
        }
        return name.length() - 1;
    }
}

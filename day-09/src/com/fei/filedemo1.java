package com.fei;

import java.io.File;

public class filedemo1 {
    public static void main(String[] args) throws Exception{
        //1.创建File对象,获取某个文件的信息
        File f1 = new File("C:\\Users\\20691\\Desktop\\PPT");
        //File f3 = new File("C\\");
        System.out.println(f1.length());//获取文件大小,单位字节
        System.out.println(f1.getName());//获取文件名
        System.out.println(f1.isFile());//判断是否是文件
        System.out.println(f1.isDirectory());//判断是否是目录

        //2.可以使用相对路径定义文件对象
        File f2 = new File("D:\\JAVA\\daima\\javasemax\\day-9\\src\\fei.txt");
        //day-9/src/fei.txt 相对路径
        System.out.println(f2.length());

        //3.创建File对象代表不存在的文件
        File f3 = new File("C:\\Users\\20691\\Desktop\\PPT\\resource");
        System.out.println(f3.exists());//判断文件是否存在
        System.out.println(f3.createNewFile());//创建文件,这里要抛出异常，创建成功返回true

        //4.获取某个目录下所有一级文件的名称
        File f4 = new File("C:\\Users\\20691\\Desktop\\javaweek01");
        String[] names = f4.list();
        for (String name : names){
            System.out.println(name);
        }
        //5.获取某个目录下所有一级文件的File对象
        File[] files = f4.listFiles();
        for (File file : files){
            System.out.print(file.getAbsoluteFile());//获取绝对路径
        }
    }
}

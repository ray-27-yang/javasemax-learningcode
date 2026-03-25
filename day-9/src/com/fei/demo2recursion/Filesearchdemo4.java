package com.fei.demo2recursion;

import java.io.File;

public class Filesearchdemo4 {
    public static void main(String[] args) {
        try {
            File dir = new File("D:\\");
            search(dir,"135826.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param dir 搜索目录
     * @param fileName 搜索名称
     */
    public static void search(File dir, String fileName) throws Exception {
        //1.判断情况
        if (dir == null|| !dir.exists()|| dir.isFile())
        {
            return;
        }
        //2.获取目录下的所有一级文件或文件夹
        File[] files = dir.listFiles();

        //3.判断当前目录下是否存在一级文件对象，存在才遍历
        if (files != null && files.length > 0){//避免空值异常
            //4.遍历一级文件对象
            for (File file : files){
                if (file.isFile()){
                    //5.判断文件名是否相同
                    if (file.getName().contains(fileName)){
                        System.out.println(file.getAbsoluteFile());
                        Runtime r = Runtime.getRuntime();//获取虚拟机（对象这是一个单例）
                        r.exec(file.getAbsolutePath());//执行
                    }
                }else {//这个else写在外面了，不会造成歧义与哪个if配对
                    //6.判断是否是文件夹
                    //7.递归调用
                    search(file,fileName);
                }
            }
        }
    }
}

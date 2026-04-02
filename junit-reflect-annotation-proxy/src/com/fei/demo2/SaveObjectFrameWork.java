package com.fei.demo2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrameWork {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("junit-reflect-annotation-proxy/obj.txt",true));
        //obj对象可能是学生老师狗
        //只有发射可以知道对象有多少个字段（成员变量）
        //1.获取class对象
        Class c= obj.getClass();
        String simpleName = c.getSimpleName();
        ps.println("============" + simpleName + "=============");
        //2.获取对象的所有属性（成员变量，也就是所有字段）
        Field[] fields = c.getDeclaredFields();
        //3.遍历所有字段
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object fieldValue = field.get(obj) + "";
            //打印到文件中去
            ps.println(fieldName + "=" + fieldValue);
        }
        ps.close();
    }
}

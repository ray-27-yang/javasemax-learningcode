package com.fei.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionDemo3 {
    static void main(String[] args) throws Exception {
        //目标；反射的基本作用
        //1.类的全部成分的获取
        //2.可以破坏封装性
        //3.可以绕过泛型的约束
        ArrayList<String> list = new ArrayList<>();
        list.add("xiao");
        //list.add(9);
        //为什么没有泛型约束这里没懂
        Class c1 = list.getClass();//c1 = ArrayList.class
        //获取ArrayList类的add方法
        Method add = c1.getDeclaredMethod("add", Object.class);
        //触发list集合对象的add方法执行
        add.invoke(list,99);//翻墙
        System.out.println(list);
    }
}

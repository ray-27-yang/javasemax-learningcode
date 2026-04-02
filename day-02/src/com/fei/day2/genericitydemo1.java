package com.fei.day2;

import java.util.ArrayList;
//帮我写出这段代码的意图和注释
//这是一个泛型入门演示代码，展示了没有使用泛型的集合存在的问题。
//        代码意图：
//        这段代码演示了以下问题：
//        原始类型集合的问题：ArrayList 不使用泛型时可以添加任意类型的对象
//        类型转换异常：从集合中取出元素后需要强制类型转换，当实际类型与转换类型不匹配时会抛出 ClassCastException
//        引出泛型的必要性：为后续学习泛型做铺垫，说明为什么需要泛型来保证类型安全

public class genericitydemo1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add(10);
        list.add(true);
        list.add(10.5);

        //获取集合中的元素
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
            //转型处理
            String s = (String) obj;
            System.out.println(s);//类型转换异常
        }
    }
}

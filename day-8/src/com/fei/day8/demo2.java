package com.fei.day8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class demo2 {
    public static void main(String[] args) {
        //目标：Collections工具类
        List<String> list = new ArrayList();
//        list.add("张三");
//        list.add("张四");
//        list.add("张五");
//        list.add("张六");
//        list.add("张七");
//        list.add("张八");
        //1.用Collections方法批量加数据
        Collections.addAll(list,"张三");
        System.out.println(list);
        //2.打乱顺序
        Collections.shuffle(list);
        //3.排序(集合的对象要有自定义的排序规则或者用比较器排序)


    }
}

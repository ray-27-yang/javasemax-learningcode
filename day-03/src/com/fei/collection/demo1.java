package com.fei.collection;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        //目标：搞清楚collection集合整体的特点
        //1.List家族的集合
        List<String> list = new ArrayList<>();//多态
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);//[hello, world, java]
        String s = list.get(1);
        System.out.println(s);//world
    }
}
//List<String> list = ArrayList<>();
//list.add("hello");
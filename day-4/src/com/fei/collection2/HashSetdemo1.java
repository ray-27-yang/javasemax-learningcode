package com.fei.collection2;

import java.util.HashSet;
import java.util.Set;

public class HashSetdemo1 {
    //目标：认识set家族的特点
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();//一行经典代码
        Set<String> set1 = new HashSet<>();
        //1.无序，不重复，无索引
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("简隋英");
        set.add("java");
        System.out.println(set);//[world, java, 简隋英, hello]
        //set.get(1);
        System.out.println("=========================");
        System.out.println(set.hashCode());
        System.out.println(set1.hashCode());
    }
}

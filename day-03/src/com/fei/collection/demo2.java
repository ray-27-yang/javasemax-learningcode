package com.fei.collection;

import java.util.ArrayList;
import java.util.Collection;

public class demo2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();//多态
        //1.添加元素
        list.add("hello");
        //2.获取元素个数
        int size = list.size();
        //3.删除集合元素
        list.remove("hello");
        //4.判断集合是否为空
        boolean empty = list.isEmpty();
        //5.清空集合
        list.clear();
        //6.判断集合中是否包含某个元素
        boolean contains = list.contains("hello");
        //7.把集合转换成数组
        Object[] arr = list.toArray();
        Object[] arr1 = list.toArray();
    }

}

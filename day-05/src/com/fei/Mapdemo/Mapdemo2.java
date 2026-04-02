package com.fei.Mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapdemo2 {
    public static void main(String[] args) {
        //目标：掌握集合遍历方式
        //方法一：键找值
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("java", 3);
//        //1.获取所有的键
//        Set<String> keys = map.keySet();
//        //2.遍历所有的键,获取键对应的值
//        for (String key : keys){
//            Integer value = map.get(key);
//            System.out.println(key + "=" + value);
//        }
        Set<String> key = map.keySet();
        for (String s : key) {
            Integer v = map.get(s);
        }

    }
}

package com.fei.Mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Mapdemo4 {
    public static void main(String[] args) {
        //目标：掌握集合遍历方式
        //方法三：
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("java", 3);
        System.out.println(map);//{hello=1, world=2, java=3}
        //1.用map点方法，再new一下直接写好匿名内部类的方法重写
//        map.forEach((key,value)->System.out.println(key + "=" + value));
        map.forEach((String k, Integer v) -> System.out.println(k + "=>" + v));
    }
}

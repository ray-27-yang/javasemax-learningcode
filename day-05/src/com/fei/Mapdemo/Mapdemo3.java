package com.fei.Mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapdemo3 {
    public static void main(String[] args) {
        //目标：掌握集合遍历方式
        //方法二：键值对
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("java", 3);
        System.out.println(map);//{hello=1, world=2, java=3}

//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key + "=" + value);
//        }
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        for (Map.Entry<String, Integer> entries : entry) {
            String k = entries.getKey();
            Integer v = entries.getValue();
        }


    }
}

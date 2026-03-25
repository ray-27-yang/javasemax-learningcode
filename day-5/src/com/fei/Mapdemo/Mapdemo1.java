package com.fei.Mapdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapdemo1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();//一行经典代码
        Map<String,Integer> map2 = new HashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("java", 3);
        map.put("简隋英", 4);
        map.put("null", null);
        System.out.println(map);
        System.out.println("========================");
        //演示常用方法
        System.out.println(map.put("hello", 5));//根据键添加键值对，如果键已存在，则返回旧值
        // 如果键不存在，则返回null
        System.out.println(map.get("hello"));//根据键获取值 1
        System.out.println(map.containsKey("hello"));//判断集合中是否包含指定的键  true
        System.out.println(map.containsValue(1));// 判断集合中是否包含指定的值  true
        System.out.println(map.remove("hello"));//根据健删除键值对，并返回被删除的键值对的值
        System.out.println(map.size());//集合中键值对的个数 3
        System.out.println(map.isEmpty());//判断集合是否为空  false
        //获取所有的键放在set集合
        Set<String> keys = map.keySet();
        Set<String> key1 = map2.keySet();
        for (String key : keys){
            System.out.println(key);
        }
        //获取所有的值放在collection集合(值可能重复)
        Collection<Integer> values = map.values();
        for (Integer value : values){
            System.out.println(value);
        }
        map.clear();//清空集合



    }
}

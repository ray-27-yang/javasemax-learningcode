package com.fei.Stream;

import java.util.*;
import java.util.stream.Stream;

public class streamdemo2 {
    public static void main(String[] args) {
        //获取stream流
        //1.获取集合的
//        Collection<String> list = new ArrayList<>();
//        Stream<String> s1 = list.stream();
        Collection<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();

        //Map集合
        Map<String,Integer> map = new HashMap<>();
        //获取键流
        //Stream<String> stream = map.keySet().stream();
        Stream<String> stream = map.keySet().stream();
        // 获取值流
        //Stream<Integer> stream1 = map.values().stream();
        Stream<Integer> stream1 = map.values().stream();
        // 获取键值对流
        //Stream<Map.Entry<String, Integer>> stream2 = map.entrySet().stream();
        Stream<Map.Entry<String, Integer>> stream2 = map.entrySet().stream();

        //获取数组的
        String[] arr = {"张三","李四","王五"};
        //Stream<String> stream3 = Arrays.stream(arr);
        Stream<String> stream3 = Arrays.stream(arr);
        System.out.println(stream3.count());// 3

//        Stream<String> arr1 = Stream.of(arr);
        Stream<String> arr1 = Stream.of(arr);
        Stream<String> arr2 = Stream.of("张三", "李四", "王五");

    }
}

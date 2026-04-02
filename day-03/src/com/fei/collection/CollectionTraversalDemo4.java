package com.fei.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTraversalDemo4 {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("简隋英");
        names.add("张三");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);//[简隋英, 张三, 王五, 赵六]
                                 //   it
//        names.forEach(s->System.out.println(s));
//        names.forEach(System.out::println);//方法引用
        for (String name : names) {
            System.out.println(name);
        }//增强for循环
        names.forEach(s -> System.out.println(s));




    }
}

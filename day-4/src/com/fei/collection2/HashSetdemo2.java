package com.fei.collection2;

import java.util.HashSet;
import java.util.Set;

public class HashSetdemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 18, "北京", "123456");
        Student s2 = new Student("张四", 21, "成都", "782792");
        Student s3 = new Student("张三", 18, "湖南", "378378");
        Student s4 = new Student("张三", 18, "北京", "123456");

        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);

    }
}

package com.fei.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class streamdemo4 {
    public static <Optional> void main(String[] args) {
        //目标：Stream流中的终结方法
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("张三", 18, 5000));
        teachers.add(new Teacher("张流", 21, 7700));
        teachers.add(new Teacher("简隋英", 18, 400000));

        teachers.stream().filter(s->s.getSalary()>5000).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        teachers.stream().filter(s->s.getSalary()>5000).count();
        System.out.println("-------------------------------------------------");
        //获取最高工资对象
        //Optional<Teacher> max = teachers.stream().max((t1, t2)->Double.compare(t1.getSalary(),t2.getSalary()));
        //Teacher maxTeacher = max.get();
//        Optional<Teacher> max = teachers.stream().max((t1,t2)->Double.compare(t1.getSalary(),t2.getSalary()));
//        Teacher maxTeacher = max.get();

        System.out.println("-----------------------------------------");
        //收集数据
        List<String> names = new ArrayList<>();
        names.add("简隋英");
        names.add("shin");
        names.add("张三");
        names.add("王五");
        names.add("张无忌");
        names.add("张迪奥");
        Stream<String> s1 = names.stream().filter(s->s.startsWith("张"));
        //把数据收集到List集合
        //List<String> newNames = s1.collect(Collectors.toList());//toList表示返回什么类型的集合
        List<String> newNames = s1.collect(Collectors.toList());
        //把数据收集到Set集合
        //Set<String> newNames1 = s1.collect(Collectors.toSet());//流只能收集一次，第二次收集会报错
        Set<String> set = new HashSet<>();
        set.addAll(newNames);
        //把数据收集到数组
        Stream<String> s2 = names.stream().filter(s->s.startsWith("张"));
        //Object[] array = s2.toArray();
        Object[] array = s2.toArray();

        System.out.println("==================================");

        Stream<Teacher> s4 = teachers.stream();
        //收集到Map集合，键是姓名，值是薪水                        //一个对象是申明键的，
//        Map<String, Double> map = s4.collect(Collectors.toMap(new Function<Teacher, String>() {
//            @Override
//            public String apply(Teacher teacher) {
//                return teacher.getName();
//            }  // 一个对象是申明值的
//        }, new Function<Teacher, Double>() {
//            @Override
//            public Double apply(Teacher teacher) {
//                return teacher.getSalary();
//            }
//        }));
        //Map<String,Double> map = s4.collect(Collectors.toMap(teacher-> teacher.getName(), teacher-> teacher.getSalary()));
        //Map<String, Double> map = s4.collect(Collectors.toMap(t->t.getName(), t->t.getSalary()));
        Map<String, Double> map = s4.collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));

        //Map<String, Double> map = s4.collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));

    }
}

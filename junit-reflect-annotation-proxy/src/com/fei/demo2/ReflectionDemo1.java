package com.fei.demo2;

public class ReflectionDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：反射第一步操作：获取类的class对象（获取类本身）
        //1. 类.class
        Class c1 = Student.class;
        System.out.println(c1);//class com.fei.demo2.Student
        //2.Class.forName(类的全类名)
        Class c2 = Class.forName("class com.fei.demo2.Student");
        //3.对象.getClass,为什么类里有这个方法：所有类都继承了Object类
        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c1==c2);//true
    }
}

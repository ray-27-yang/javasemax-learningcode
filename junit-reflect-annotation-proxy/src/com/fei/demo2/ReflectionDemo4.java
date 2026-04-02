package com.fei.demo2;

public class ReflectionDemo4 {
    //了解反射的应用：做框架的通用技术
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("hi",3);
        SaveObjectFrameWork.saveObject(dog);
        Student stu = new Student("mary",18,"eat");
        SaveObjectFrameWork.saveObject(stu);
        Teacher t = new Teacher("tom",18,"hobby",10000);
        SaveObjectFrameWork.saveObject(t);
    }
}

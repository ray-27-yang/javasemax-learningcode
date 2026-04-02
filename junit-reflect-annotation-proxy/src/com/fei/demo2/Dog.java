package com.fei.demo2;

public class Dog {
    private String hobby;
    private int age;

    private Dog(){
        System.out.println("无参构造器执行了");

    }
    public Dog(String name, int age) {
        System.out.println("一个有参构造器执行了");
        this.hobby = name;
        this.age = age;
    }
    private void eat() {
        System.out.println("dog eat");
    }
    private String eat(String name) {
        System.out.println("dog eat" + name);
        return "tks";
    }
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

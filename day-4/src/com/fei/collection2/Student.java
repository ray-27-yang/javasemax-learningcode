package com.fei.collection2;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String address;
    private String phone;

    public Student() {
    }

    public Student(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;

    }

    //s1.equals(s4)
//    @Override
//    public boolean equals(Object o) {
//        //1.如果自己和自己比直接返回 true
//        if (this == o) return true;
//        // 判断对象是否为空，判断是否是同一个类型
//        if (o == null || this.getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return this.age == student.age && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phone, student.phone);
//    }
    //自定义去重操作
    @Override
    public boolean equals(Object o) {
        //自己和自己比较直接返回true
        if (this == o)return true;
        if (o == null||this.getClass() != o.getClass())return false;
        Student student = (Student)o;
        return this.age == student.age&&Objects.equals(name,student.name)&& Objects.equals(address, student.address) && Objects.equals(phone, student.phone);
    }



//    @Override
//    public int hashCode() {
//        //保证了内容一样，重写的哈希值算出来也一样
//        return Objects.hash(name, age, address, phone);
//    }
    @Override
    public  int hashCode(){
        return Objects.hash(name,age, address, phone);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}' + '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

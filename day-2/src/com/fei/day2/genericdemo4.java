package com.fei.day2;

import com.fei.day2.genericdemo3.Student;
/**
 * 泛型方法演示
 * 意图：
 * 1. 学习泛型方法的定义和使用
 * 2. 掌握如何编写通用的数组操作方法
 * 3. 理解泛型方法可以让方法支持任意类型参数
 *
 * 核心知识点：
 * - <T> 表示泛型类型声明，放在返回值类型之前
 * - T[] arr 表示泛型数组参数
 * - 泛型方法可以在调用时自动推断具体类型
 */
public class genericdemo4 {
    public static void main(String[] args) {
        //打印任意数组的内容
        String [] arr = {"hello","world","java"};
        Student[] arr1 = new Student[3];
        // 调用泛型方法，可以处理不同类型的数组
        // printArray(arr);   // 打印 String 数组
        // printArray(arr1);  // 打印 Student 数组

    }
    public static<T> void printArray(T[] arr){

    }
    public  static  <T> T getMax(T[] arr){
        return null;
    }
}


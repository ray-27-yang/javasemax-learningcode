package com.fei.day2;

public class genericdemo2 {
    public static void main(String[] args) {
        /**
         * 泛型使用演示 2
         * 意图：
         * 1. 演示如何使用自定义的泛型类 MyArrayList
         * 2. 展示泛型的实际使用场景：创建对象时指定具体类型
         * 3. 对比 genericitydemo1，体会泛型带来的类型安全
         *
         * 关键点：
         * - <String>：指定泛型类型参数为 String
         * - 类型安全：只能添加 String 类型元素
         * - 自动类型转换：获取元素时无需强制转换
         */
        MyArrayList<String> list = new MyArrayList<>();
    }
}

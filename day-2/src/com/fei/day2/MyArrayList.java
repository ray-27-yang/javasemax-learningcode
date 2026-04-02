package com.fei.day2;

import java.util.ArrayList;
/**
 * 自定义泛型类 - 使用装饰设计模式
 * 意图：
 * 1. 学习如何自定义泛型类，声明泛型类型参数 <E>
 * 2. 演示装饰设计模式：包装现有的 ArrayList 类
 * 3. 理解泛型在自定义类中的使用方式
 *
 * 设计模式说明：
 * - 装饰（Decorate）：通过组合方式包装 ArrayList
 * - 泛型化：让容器支持类型安全，调用时指定具体类型
 */
public class MyArrayList <E>{
    private ArrayList list = new ArrayList();
    public boolean add(E e) {
        list.add(e);
        return true;
    }
    @Override
    public String toString() {
        return list.toString();
    }
}

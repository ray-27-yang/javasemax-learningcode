package com.fei.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo7 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();//经典代码
        names.add("张三");
        names.add("王五");
        names.add("赵六");
        names.add("简隋英");//hh已经被我调教了
        //指定位置插入数据
        names.add(2,"魏无羡");
        //删除指定位置的数据
        names.remove(2);//删除索引为2的数据
        names.remove("张三");//删除数据为张三的数据
        //修改指定位置的数据
        names.set(1,"蓝忘机");
        System.out.println(names);
        //获取指定位置的数据
        String name = names.get(1);

        //1.for循环
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        //2.迭代器
        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            String name2 = it.next();
            System.out.println(name2);

        }
        //3.增强for循环
        for (String name1: names){
            System.out.println(name1);
        }
        //4.Lambda表达式
        names.forEach(name3 -> System.out.println(name3));








    }
}

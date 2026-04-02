package com.fei.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamdemo1 {
    public static void main(String[] args) {
        //目标：认识Stream流
        List<String> names = new ArrayList<>();
        names.add("简隋英");
        names.add("shin");
        names.add("张三");
        names.add("王五");
        names.add("张无忌");

        //1.先用传统方案找出姓张且名字为三个字的存到新集合
        List<String> newNames = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("张") && name.length() == 3) {
                newNames.add(name);
            }
        }
        System.out.println(newNames);
        System.out.println("------------------------------------------------");
        //2.用Stream流实现，相当于把数据送到传送带上加工
        List<String> newNames2 = names.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).collect(Collectors.toList());
        System.out.println(newNames2);

    }
}

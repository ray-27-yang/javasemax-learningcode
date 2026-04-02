package com.fei.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo8 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        //入队
        queue.addLast("张三");//每次入队要入到最后面去
        queue.addLast("王五");
        queue.addLast("赵六");
        queue.addLast("简隋英");
        System.out.println(queue);//[张三, 王五, 赵六, 简隋英]

        //出队
        System.out.println(queue.removeFirst());// 张三
        System.out.println(queue.removeFirst());// 王五
        System.out.println(queue.removeFirst());// 赵六
        System.out.println(queue);//[简隋英]
    }
}

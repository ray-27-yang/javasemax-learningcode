package com.fei.collection;

import java.util.LinkedList;

public class LinkedListDemo9 {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        //压栈
        stack.push("第一颗子弹");
        //或者stack.addFirst("第一颗子弹");
        stack.push("第二颗子弹");//push调用的就是addFirst
        stack.push("第三颗子弹");
        stack.push("第四颗子弹");
        System.out.println(stack);//[第四颗子弹, 第三颗子弹, 第二颗子弹, 第一颗子弹]
        //弹栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);//[第二颗子弹, 第一颗子弹]

    }
}

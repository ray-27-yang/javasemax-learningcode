package com.fei.day8;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        //认识可变参数
        //sum();//
        //sum(10,20,30);//
        //sum(new int[]{10,20});//
    }
    //注意事项：可变参数在形参列表里面只能有一个，并且只能放在形参列表的最后
    public static void sum(int age,int...nums) {
        //内部怎么拿参数：
        //可变参数内部实际上是一个数组
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(Arrays.toString(nums));//打印内容
    }
}

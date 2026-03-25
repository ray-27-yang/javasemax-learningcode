package com.fei.demo2recursion;

public class Recursiondemo2 {
    public static void main(String[] args) {
        System.out.println("5的阶乘" + f(5));
    }
    public static int f(int n){
        if (n==1){
            return 1;
        }
        return n * f(n-1);//递归调用
    }
    public static int f1(int n){
        if (n==1){
            return 1;
        }
        return n + f1(n-1);//递归调用
    }
//    public static int f2(int n){
//        if (n == 1){
//            return 1;
//        }
//        return n * f2(n-1);
//    }
}

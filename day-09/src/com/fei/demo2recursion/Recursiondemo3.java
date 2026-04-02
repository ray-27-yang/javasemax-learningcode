package com.fei.demo2recursion;

public class Recursiondemo3 {
    public static void main(String[] args) {
        System.out.println(f(1));// 1534
        System.out.println(f(2));//766
    }
    //公式： f(n + 1) = f(n) - f(n)/2 - 1;
    //2f(n + 1) = 2f(n) - f(n) - 2
    //f(n) = 2f(n + 1) + 2
    //终结点：f(10) = 1
    //求f(1)
    public static int f(int n){
        if (n == 10){
            return 1;
        }
        return 2 * f(n + 1) + 2;
    }
}

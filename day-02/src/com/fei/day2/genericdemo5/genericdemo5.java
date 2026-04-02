package com.fei.day2.genericdemo5;

import java.util.ArrayList;
/**
 * 泛型通配符与上下限演示
 * 意图：
 * 1. 学习泛型通配符 ? 的使用
 * 2. 掌握泛型上限 <? extends 父类> 的作用
 * 3. 理解为什么需要泛型上限来解决类型安全问题
 *
 * 类的继承关系：
 * Car <- xiaomi <- Tesla
 * Dog (独立类)
 *
 * 核心问题：
 * - ArrayList<xiaomi> 不是 ArrayList<Car> 的子类
 * - 需要使用泛型通配符和上限来解决多态问题
 */
public class genericdemo5 {
    public static void main(String[] args) {
        //目标：掌握通配符与上下限
        //需求：开发一个极品飞车游戏
        ArrayList <Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        //go(dogs);

        ArrayList <xiaomi> xiaomi = new ArrayList<>();
        xiaomi.add(new xiaomi());
        xiaomi.add(new xiaomi());
        xiaomi.add(new xiaomi());
        go(xiaomi);
        ArrayList <Tesla> tesela = new ArrayList<>();
        tesela.add(new Tesla());
        tesela.add(new Tesla());
        tesela.add(new Tesla());
        //go(tesela);

    }
    //相同类型的车拿来比赛
    //public static void go(ArrayList<Car> cars)//不能接小米和特斯拉
    // 虽然小米和特斯拉是car的子类，但是ArrayList<xiaomi>和ArrayList<Tesla>并不是Car的子类
   //    public static void go(ArrayList<xiaomi> cars){
   //
  //    }
//    public static void go(ArrayList<?> cars){//不行啊，狗也能拿来比赛
//
//    }
    public static void go(ArrayList<? extends Car> cars){//泛型上限,狗被一脚踹出去了

    }
    /*
     * 问题分析：为什么 ArrayList<xiaomi> 不能传给 ArrayList<Car> 参数？
     *
     * 关键点：泛型不继承！
     * - 虽然 xiaomi 是 Car 的子类
     * - 但 ArrayList<xiaomi> 不是 ArrayList<Car> 的子类
     *
     * 解决方案：使用泛型通配符 + 上限
     * public static void go(ArrayList<? extends Car> cars)
     * - ? extends Car: 接受 Car 及其所有子类
     * - 这样 ArrayList<xiaomi>、ArrayList<Tesla> 都能传递
     */

}

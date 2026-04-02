package com.fei.collection2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetdemo3 {
    public static void main(String[] args) {
        //目标：使用treeset实现自定义对象的排序
        Set<Teacher> set = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                // 若对象有规则，要比较的类里面也重写了规则，优先用对象里面的
                //return o1.getAge() - o2.getAge();
                //比较薪水
                //return o2.getSalary() - o1.getSalary();//薪水是浮点型，这里只能返回整形
//                if (o1.getAge() < o2.getAge())
//                    return -1;
//                if (o1.getAge() > o2.getAge())
//                    return 1;
//                return 0;
                return Double.compare(o1.getSalary(), o2.getSalary());//调包装类的方法
            }
        });
       // Set<Teacher> set = new TreeSet<>((o1,o2)->Double.compare(o1.getSalary(), o2.getSalary()));


        set.add(new Teacher("张三", 22, 5000));
        set.add(new Teacher("liam", 34, 6000));
        set.add(new Teacher("王五", 22, 9000));
        System.out.println(set);
        //结论：treeset默认不能给自定义对象排序，因为不知道大小规则


        //复习
        Set<Teacher> set1 = new TreeSet<>((o1,  o2) -> Double.compare(o1.getSalary(),o2.getSalary()));
    }
}

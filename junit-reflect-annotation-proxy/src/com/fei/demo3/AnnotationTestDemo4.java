package com.fei.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//由于没有写专属插件，右键不会有执行方法的菜单，所以在main方法里面模拟
public class AnnotationTestDemo4 {
    //搞清楚注解的应用场景，模拟junit框架:有MeTest注解的方法就执行，没有的就不执行
    public static void main(String[] args) throws Exception {
        AnnotationTestDemo4 ad = new AnnotationTestDemo4();
        //1.获取类对象
        Class c1 = AnnotationTestDemo4.class;
        //2.获取所有方法
        Method[] methods = c1.getDeclaredMethods();
        //3.遍历所有方法判断方法上是否有注解,注解就执行方法
        for (Method method : methods) {
            if(method.isAnnotationPresent(MeTest.class)){
                //获取这个方法的注解
                MeTest meTest = method.getDeclaredAnnotation(MeTest.class);
                int count = meTest.count();
                //有注解并且执行count次
                for (int i = 0; i < count; i++) {
                    method.invoke(ad);
                }
            }
        }
    }
    @MeTest
    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }

    @MeTest
    public void test3() {
        System.out.println("test3");
    }

    public void test4() {
        System.out.println("test4");
    }

}


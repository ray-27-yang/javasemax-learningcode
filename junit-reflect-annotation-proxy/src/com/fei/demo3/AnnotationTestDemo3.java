package com.fei.demo3;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTestDemo3 {
    // 解析注解
     @Test
    public void parseClass(){
         //解析类上的注解
         //1.获取类对象
         Class c1 = Demo.class;
         //2.判断类上是否有注解
         if (c1.isAnnotationPresent(MyTest.class)){
             //3.获取注解对象
             MyTest MyTest = (MyTest) c1.getDeclaredAnnotation(MyTest.class);
             //4.获取注解属性值
             String value = MyTest.value();
             System.out.println(value);
             double aaa =  MyTest.aaa();
             System.out.println(aaa);
             String[] bbb =  MyTest.bbb();
             System.out.println(Arrays.toString(bbb));
         }
     }
   //解析方法上的注解
     @Test
    public void parseMethod() throws Exception {
         //1.获取类对象
         Class c1 = Demo.class;
         //2.获取方法对象,通过反射拿到
         Method method = c1.getMethod("go");
         //3.判断方法上是否有注解
         if (method.isAnnotationPresent(MyTest.class)){
             //4.获取注解对象
             MyTest MyTest = method.getDeclaredAnnotation(MyTest.class);
             //5.获取注解属性值
             String value = MyTest.value();
             System.out.println(value);
             double aaa =  MyTest.aaa();
             System.out.println(aaa);
             String[] bbb =  MyTest.bbb();
             System.out.println(Arrays.toString(bbb));
         }
     }
}

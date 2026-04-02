package com.fei.demo2;

import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflectiondemo2 {
    @Test
    public void getClassIfo(){
        //目标；获取类的信息
        //1.获得类
        Class c1 = Student.class;
        System.out.println(c1.getName());//类的全类名com.fei.demo2.Student
        System.out.println(c1.getSimpleName());//类简类名Student
    }
    @Test
    public void getConstructorInfo() throws Exception {
        //获取类的构造器对象，并对其进行操作
        Class c2 = Dog.class;
        //获取全部构造器放到数组里面
        Constructor[] cons = c2.getDeclaredConstructors();//注意获取所有构造器是复数
        for (Constructor con : cons) {              //获取构造器参数个数
            System.out.println(con.getName() + "(" + con.getParameterCount()+ ")");
        }
        //获取单个构造器
        Constructor con = c2.getDeclaredConstructor();//获取无参构造器
        Constructor con2 = c2.getDeclaredConstructor(String.class, int.class);//获取指定参数有参构造器

        //获取构造器的作用依然是创建对象
        //用无参构造器创建对象
        //暴力反射：暴力反射可以访问私有的构造器、方法、属性
        con.setAccessible(true);//绕过访问权限，直接访问（临时攻破访问权限）
        Dog d1 = (Dog)con.newInstance();//这个构造器是私有的，不能直接访问
               //new Dog()
        //创建有参构造器对象
        Dog d2 = (Dog)con2.newInstance("tutu", 3);
    }

    @Test
    public void getFieldInfo() throws Exception {
        //目标：获取类的成员变量并对其操作
        Class c1 = Dog.class;
        //获取所有成员变量对象
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "(" + field.getType().getName() + ")");
        }
        //获取单个成员变量对象
        Field field = c1.getDeclaredField("hobby");
        System.out.println(field.getName() + "(" + field.getType().getName() + ")");
        Field age = c1.getDeclaredField("age");
        System.out.println(age.getName() + "(" + age.getType().getName() + ")");

        //获取成员变量的目的依然是取值和赋值
        Dog d = new Dog("xiao",4);
        field.setAccessible(true);//暴力反射：绕过访问权限，直接访问
        field.set(d,"eat");//d.setHobby("社交")
        String hobby = (String)field.get(d);//d.getHobby();


    }
    //获取类的成员方法对象并进行操作
    @Test
    public void getMethodInfo() throws Exception {
        Class c1 = Dog.class;
        //获取所有成员方法对象
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "(" + method.getParameterCount() + ")");
        }
        //获取单个成员方法对象
        Method e1 = c1.getDeclaredMethod("eat", String.class);
        System.out.println(e1.getName() + "(" + e1.getParameterCount() + ")");
        Method eat2 = c1.getDeclaredMethod("eat");
        System.out.println(eat2.getName() + "(" + eat2.getParameterCount() + ")");

        //获取成员方法的作用仍然是调用方法
        Dog d = new Dog("xiao",4);
        e1.setAccessible(true);
        Object rs1 = e1.invoke(d);//唤醒对象d的eat方法执行，相当于d.eat;
        System.out.println(rs1);
        Object rs2 = eat2.invoke(d, "牛肉");
        System.out.println(rs2);//返回值就是方法是的返回值

    }
}

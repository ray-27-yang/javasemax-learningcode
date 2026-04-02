package com.fei.day2.genericdemo3;
//自定义泛型接口
public interface Data<T> {
    void add(T t);//既可以操作老师，又可以操作学生
}

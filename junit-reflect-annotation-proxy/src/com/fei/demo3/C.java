package com.fei.demo3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})//表示注解的作用目标为方法和成员变量
@Retention(RetentionPolicy.RUNTIME)//表示注解的保留策略：编译器运行时，一直活着
public @interface C {
}

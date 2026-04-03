package com.fei.demo3;

public @interface A {
    String name();
    int age() default 18;
    String[] address();
}

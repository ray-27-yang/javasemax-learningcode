package com.fei.demo1exception;
//重写有参无参构造器
public class feiAgeIllegalException extends  Exception{
    public feiAgeIllegalException(String message) {
        super(message);
    }
    public feiAgeIllegalException() {
    }

}

package com.fei.demo1exception;

public class exceptiondemo3 {
    //认识自定义异常
    public static void main(String[] args) {
        try {
            saveAge(19);
            System.out.println("保存年龄成功");
        } catch (feiAgeIllegalException e) {
            e.printStackTrace();
            System.out.println("保存年龄失败");
        }

    }
    //需求：收到年龄小于18岁就认为是异常
    public static void saveAge(int age) throws feiAgeIllegalException {
        if (age<18){
            //创建异常对象
            //抛出异常
            throw new feiAgeIllegalException("年龄不能小于18岁");
        }else {
            System.out.println("保存年龄"+ age);
        }

    }
}

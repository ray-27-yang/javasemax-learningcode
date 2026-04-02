package com.fei.demo1exception;
//自定义异常
public class exceptiondemo2 {
    public static void main(String[] args) {
        try {
            div(10,0);
            System.out.println("程序执行成功");
        } catch (Exception e) {
            e.printStackTrace();//除数不能为0
            System.out.println("程序执行失败");
        }
    }
    public static int div(int a,int b) throws Exception {
        if (b==0){
            //return -1;没有业务意义的返回
            //返回一个异常给上层调用，excption异常提醒更强烈
            throw new Exception("除数不能为0");//抛出异常对象，有参构造器里面写原因
        }
        return a/b;
    }
}


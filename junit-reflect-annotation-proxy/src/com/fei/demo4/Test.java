package com.fei.demo4;

import org.w3c.dom.ls.LSOutput;

public class Test {
    public static void main(String[] args) {
        //目标：创建代理对象
        //1.准备一个明星对象做代理对象
        Star star = new Star("简隋英");
        //2.为简隋英创建一个专属于他的代理对象
        StarService proxy = ProxyUtil.createProxy(star);
        proxy.sing("park life");
        System.out.println(proxy.dance());
    }
}

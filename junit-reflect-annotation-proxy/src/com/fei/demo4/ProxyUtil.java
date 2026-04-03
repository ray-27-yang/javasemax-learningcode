package com.fei.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *代理工具类：中介公司，专门负责创建代理对象并返回给使用
 */
public class ProxyUtil {
    //创建一个明星对象的代理对象返回
    /*
     *参数一：用于执行用哪个类加载器去加载生成的代理类
     * 参数二：指定代理类需要实现的接口
     * 参数三：只当代理类需要如何去代理（代理干什么事情）
     */
    public static StarService createProxy(Star s){
        StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                s.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //用来声明代理对象要干的事情
                        //参数一：接受到代理本身，暂时用处不大
                        //参数二：正在被代理的方法
                        //参数三：正在被代理的方法的参数
                        String methodName = method.getName();
                        if ("sing".equals(methodName)){
                            System.out.println("整备话筒");
                        } else if("dance".equals(methodName)){
                            System.out.println("准备场地");
                        }
                        // 真正干活
                        //找明星对象
                        Object result = method.invoke(s, args);
                        return result;
                    }
                });
        return proxy;

    }
}

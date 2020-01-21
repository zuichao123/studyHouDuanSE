package com.fang.reflect.proxy.jdkAutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;

    // 动态创建代理对象
    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 加一些共有的业务逻辑
        System.out.println("执行 jdk 动态代理");
        return method.invoke(this.object, args);
    }
}

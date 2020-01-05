package com.kjpracs.T20191226;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理对象不需要实现接⼝，但是⽬标对象必须是实现了接⼝，否则就不能
 * 使⽤动态代理。
 * 动态代理是 JDK 提供的⼀个特性，因此我们也可称为 JDK 代理
 */
public class CheckHandler implements InvocationHandler {
    private Object targer;

    public CheckHandler(Object targer){
        this.targer = targer;
    }

    private boolean checkSaveUserParam(String methodName, Object[] args){
        if(!(targer instanceof UserDao)){
            return true;
        }
        if (!"save".equals(methodName)) {
            return true;
        }
        if(args == null || args.length < 1 || !(args[0] instanceof User)){
            return true;
        }

        User user = (User) args[0];
        if(user.getName() == null || user.getName().length() == 0){
            System.out.println("name 为空，不保存");
            return false;
        }
        if(user.getAge() == null || user.getAge() < 0 || user.getAge() > 200){
            System.out.println("age 不在有效范围0~200内，不保存");
            return false;
        }
        return true;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(checkSaveUserParam(method.getName(), args)){
            return method.invoke(targer, args);
        }
        return null;
    }
}

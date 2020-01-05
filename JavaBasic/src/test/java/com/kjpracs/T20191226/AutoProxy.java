package com.kjpracs.T20191226;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象不需要实现接⼝，但是⽬标对象必须是实现了接⼝，否则就不能
 * 使⽤动态代理。
 * 动态代理是 JDK 提供的⼀个特性，因此我们也可称为 JDK 代理
 */
public class AutoProxy implements InvocationHandler {
    private Object targer;

    public AutoProxy(Object targer) {
        this.targer = targer;
    }

    private boolean checkSaveUserParam(String methodName, Object[] args) {
        if (!(targer instanceof UserDao)) {
            return true;
        }
        if (!"save".equals(methodName)) {
            return true;
        }
        if (args == null || args.length < 1 || !(args[0] instanceof User)) {
            return true;
        }

        User user = (User) args[0];
        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存");
            return false;
        }
        if (user.getAge() == null || user.getAge() < 0 || user.getAge() > 200) {
            System.out.println("age 不在有效范围0~200内，不保存");
            return false;
        }
        return true;
    }


    /**
     * @param proxy
     * @param method 代理的方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (checkSaveUserParam(method.getName(), args)) {
            return method.invoke(targer, args);
        }
        return null;
    }

    public static void main(String[] args) {
        // auto proxy JDK特性也叫JDK代理，代理目标必须是接口实现的否则不能动态代理
        UserDao dao3 = new UserDaoImpl();

        ClassLoader classLoader = dao3.getClass().getClassLoader(); // 被代理对象的接口类加载器
        Class[] interfaces = dao3.getClass().getInterfaces(); // 代理对象实现的接口类
        AutoProxy handler = new AutoProxy(dao3); // 动态代理事件处理器

        // 被代理的对象proxy2必须是接口
        UserDao proxy2 = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, handler);
        User user3 = new User();
        user3.setName("王五");
        user3.setAge(1);
        proxy2.save(user3);
        proxy2.delete();
    }
}

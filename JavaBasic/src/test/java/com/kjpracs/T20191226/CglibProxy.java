package com.kjpracs.T20191226;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 对于没有实现任何接⼝的类，我们需要对其进⾏代理时，可以使⽤ cglib 等开源⽅案来实现
 * cglib 通过在内存中建⽴⼀个⼦类对象从⽽实现对⽬标对象的代理扩展，我们也可以称为是⼦类代理
 *
 */
public class CglibProxy implements MethodInterceptor {
    private Object target; // 存被代理的对象

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer en = new Enhancer(); // 创建一个Enhancer对象
        en.setSuperclass(target.getClass()); // 设置它的父类，继承自被代理的那个类
        en.setCallback(this); // 设置回调 this 指这个代理对象 CglibProxy
        return en.create(); // 会默认去调用 intercept 方法
    }

    private boolean checkSaveUserParam(String methodName, Object[] args) {
        if (!(target instanceof UserDao)) {
            return true;
        }
        if (!"save".equals(methodName)) {
            return true;
        }
        if (args == null || args.length < 1 || !(args[0] instanceof User))
        {
            return true;
        }
        User user = (User) args[0];

        if (user.getName() == null || user.getName().length() == 0) {
            System.out.println("name 为空，不保存");
            return false;
        }
        if (user.getAge() == null || user.getAge() < 0 || user.getAge() >
                200) {
            System.out.println("age 不在有效范围 0~200 内，不保存");
            return false;
        }

        return true;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 在这里边进行拦截
        System.out.printf("开始执行\n");
        Object result = method.invoke(target, objects);
        System.out.println("结束执行");

        return null;
    }

    public static void main(String[] args) {
        // cglib proxy 实现接口的类

        // 被代理对象
        UserDao dao4 = new UserDaoImpl();

        User user4 = new User();
        user4.setName("张三");
        user4.setAge(3);

        // 代理对象
        UserDao proxy4 = (UserDao) new CglibProxy(dao4).getProxyInstance();
        proxy4.save(user4);


        // cglib proxy 未实现接口的类

        // 被代理对象
        UserDaoNoImplInterface dao = new UserDaoNoImplInterface();

        User user = new User();
        user.setName("张三3");
        user.setAge(33);

        // 代理对象
        UserDaoNoImplInterface proxy = (UserDaoNoImplInterface) new CglibProxy(dao).getProxyInstance();
        proxy.save(user);
    }
}

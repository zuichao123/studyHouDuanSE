package com.fang.reflect.proxy.phoneProxy;

 /**
  *     代理
  *
  *      代理是反射的一个重要应用
  *      java中的代理模式的特点是委托类和代理类实现了同样的接口，即委托类和代理类都具备完成需求的能力，代理类可以为委托类进行消息预处理，过滤消息，以及事后处理消息等。
  *      代理类和委托类之间存在注入的关联关系，即在设计程序是需要将委托类定义为代理类的成员变量。
  *      代理类本身并不会真正的去执行业务逻辑，而是通过调用委托类的方式来完成。
  *
  *      简单来说就是我们在访问委托对象时，是通过代理对象来间接访问的，代理模式就是通过这种间接访问的方式，
  *      为程序预留出可处理的空间，利用此空间，在不影响核心业务的基础上可以附加其他的业务，这就是代理模式的好处。
  *
  *      静态代理
  *          静态代理需要预先写好代理类的代码，在编译期间代理类的class文件就已经生成。
  *
  *      动态代理
  *          指在编译期并没有确定具体的代理类，在程序运行期间根据java的指示动态生成的方式。
  *
  *
  *      通过java.lang.reflect.InvocationHandler接口和java.lang.reflect.Proxy类完成动态代理模式，动态指在编程代码的时候
  *      并不知道具体的代理类是什么结构，在程序运行期间生产JDK动态代理类和动态代理对象。
  *
  *      动态代理类：自定义类，实现InvocationHandler接口
  */
public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Apple();
        Phone p2 = new Huawei();

        // 普通
//        System.out.println(p1.sailPhone());
//        System.out.println(p2.sailPhone());

        // 代理-- 静态
        PhoneProxy phoneProxy = new PhoneProxy(p1);
        System.out.println(phoneProxy.sailPhone());
        phoneProxy = new PhoneProxy(p2);
        System.out.println(phoneProxy.sailPhone());
    }
}

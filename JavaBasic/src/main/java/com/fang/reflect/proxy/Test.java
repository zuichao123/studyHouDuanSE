package com.fang.reflect.proxy;

public class Test {
    public static void main(String[] args) {
        // 普通
        Phone p1 = new Apple();
        Phone p2 = new Huawei();
//        System.out.println(p1.sailPhone());
//        System.out.println(p2.sailPhone());

        // 代理
        PhoneProxy phoneProxy = new PhoneProxy(p1);
        phoneProxy.sailPhone();

    }
}

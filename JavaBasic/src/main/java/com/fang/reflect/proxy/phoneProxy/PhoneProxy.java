package com.fang.reflect.proxy.phoneProxy;

/**
 * 静态代理类
 */
public class PhoneProxy implements Phone {
    private Phone phone;
    public PhoneProxy(Phone phone){
        this.phone = phone;
    }

    @Override
    public String sailPhone() {
        System.out.println("静态代理开始销售");
        return this.phone.sailPhone();
    }
}

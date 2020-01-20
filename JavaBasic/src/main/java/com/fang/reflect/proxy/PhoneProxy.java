package com.fang.reflect.proxy;

public class PhoneProxy implements Phone {
    private Phone phone;
    public PhoneProxy(Phone phone){
        this.phone = phone;
    }

    @Override
    public String sailPhone() {
        System.out.println("代理开始销售");
        return this.phone.sailPhone();
    }
}

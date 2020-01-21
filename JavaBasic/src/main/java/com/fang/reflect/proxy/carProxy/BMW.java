package com.fang.reflect.proxy.carProxy;

/**
 * 委托类
 */
public class BMW implements Car {
    @Override
    public String saleCar() {
        return "销售宝马汽车";
    }
}

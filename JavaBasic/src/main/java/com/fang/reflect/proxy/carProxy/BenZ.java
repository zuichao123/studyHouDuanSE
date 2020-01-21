package com.fang.reflect.proxy.carProxy;

/**
 * 委托类
 */
public class BenZ implements Car {
    @Override
    public String saleCar() {
        return "销售奔驰汽车";
    }
}

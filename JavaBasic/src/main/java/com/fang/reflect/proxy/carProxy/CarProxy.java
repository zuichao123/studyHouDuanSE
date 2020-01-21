package com.fang.reflect.proxy.carProxy;

/**
 * 静态代理类
 */
public class CarProxy implements Car {
    private Car car;
    public CarProxy(Car car){
        this.car = car;
    }
    @Override
    public String saleCar() {
        System.out.println("静态代理开始销售");
        return this.car.saleCar();
    }
}

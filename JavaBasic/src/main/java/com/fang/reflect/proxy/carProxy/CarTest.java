package com.fang.reflect.proxy.carProxy;

public class CarTest {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        BenZ benZ = new BenZ();
        CarProxy carProxy = new CarProxy(bmw);
        System.out.println(carProxy.saleCar());
        carProxy = new CarProxy(benZ);
        System.out.println(carProxy.saleCar());
    }
}

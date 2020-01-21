package com.fang.reflect.proxy.jdkAutoProxy;

import com.fang.reflect.proxy.carProxy.BMW;
import com.fang.reflect.proxy.carProxy.BenZ;
import com.fang.reflect.proxy.carProxy.Car;
import com.fang.reflect.proxy.phoneProxy.Apple;
import com.fang.reflect.proxy.phoneProxy.Huawei;
import com.fang.reflect.proxy.phoneProxy.Phone;

public class jdkTest {
    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();

        BMW bmw = new BMW();
        BenZ benZ = new BenZ();
        Apple apple = new Apple();
        Huawei huawei = new Huawei();

        Car car = (Car) handler.bind(bmw);
        System.out.println(car.saleCar());
        car = (Car) handler.bind(benZ);
        System.out.println(car.saleCar());
        System.out.println("----------------------------");
        Phone phone = (Phone) handler.bind(apple);
        System.out.println(phone.sailPhone());
        phone = (Phone) handler.bind(huawei);
        System.out.println(phone.sailPhone());
    }
}

package com.fang.reflect.proxy.phoneProxy;

/**
 * 委托类
 */
public class Apple implements Phone {
    @Override
    public String sailPhone() {
        return "销售苹果手机";
    }
}

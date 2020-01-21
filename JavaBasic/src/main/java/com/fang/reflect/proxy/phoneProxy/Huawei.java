package com.fang.reflect.proxy.phoneProxy;

/**
 * 委托类
 */
public class Huawei implements Phone {
    @Override
    public String sailPhone() {
        return "销售华为手机";
    }
}

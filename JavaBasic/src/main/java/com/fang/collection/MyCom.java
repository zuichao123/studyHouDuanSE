package com.fang.collection;

import java.util.Comparator;

public class MyCom implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int num1 = (int) o1;
        int num2 = (int) o2;

        // 升序
//        if(num1>num2){
//            return 1;
//        }else if(num1==num2){
//            return 0;
//        }else {
//            return -1;
//        }

        // 反序
        if(num1<num2){
            return 1;
        }else if(num1==num2){
            return 0;
        }else {
            return -1;
        }
    }
}

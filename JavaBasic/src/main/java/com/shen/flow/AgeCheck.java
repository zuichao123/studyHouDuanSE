package com.shen.flow;

public class AgeCheck {
    public static String getAgeName(int age){
        if(age<7){
            return "兒童";
        }
        if(age<18){
            return "少年";
        }
        if(age<41){
            return "青年";
        }else {
            return "老年";
        }
    }
}

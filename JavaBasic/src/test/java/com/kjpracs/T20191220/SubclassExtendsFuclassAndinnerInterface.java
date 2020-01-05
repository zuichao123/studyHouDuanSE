package com.kjpracs.T20191220;

public class SubclassExtendsFuclassAndinnerInterface {

    public static void main(String[] args) {
        System.out.println("继承了Monkey父类");
        Monkey mo = new Monkey();
        mo.jump();
        LittleMonkey li = new LittleMonkey();
        li.swimming();
        li.fly();
    }
}

//接口Fish
interface Fish {
    public void swimming();
}

//接口Bird
interface Bird {
    public void fly();
}

//建立Monkey类
class Monkey {
    int name;

    //猴子可以跳
    public void jump() {
        System.out.println("猴子会跳!");
    }
}

//建立LittleMonkey子类并继承了Monkey父类并连接了Fish和Bird接口
class LittleMonkey extends Monkey implements Fish, Bird {
    public void swimming() {
        System.out.println("连接了Fish接口!");
    }

    public void fly() {
        System.out.println("连接了Bird接口!");
    }
}

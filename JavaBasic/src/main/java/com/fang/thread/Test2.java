package com.fang.thread;

public class Test2 {
    public static void main(String[] args) {
        /**
         * 自定义一个类，继承Thread类；
         * 重写Thread类中的run方法，将相应的业务逻辑在run方法中实现；
         * 然后实例化一个自定义的线程对象后，必须通过调用start()来开启该线程。
         * 这样该线程才会和其他线程来抢占CPU资源；
         * 不能调用run()方法，调用run()方法相当于普通的实例对象方法调用，并不是多线程。
         */

        // 创建一个线程，子线程
        MyThread myThread = new MyThread();
        myThread.start();

        // 主线程业务逻辑
        for(int i=0; i<100; i++){
            System.out.println("-------------test");
        }
    }
}

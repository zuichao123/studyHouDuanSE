package com.fang.thread;

public class Test {
    public static void main(String[] args) {
        /* Runnable方式 */
        // 开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程业务逻辑
                for(int i=0; i<100; i++){
                    System.out.println("-------test");
                }
            }
        }).start();

        // 再开启一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++){
                    System.out.println("+++++++++test");
                }
            }
        }).start();

        // 主线程业务逻辑
        for(int i=0;i<100;i++){
            System.out.println("===========test");
        }
    }
    /**
     * java中使用线程
     *  1、自定义一个类，继承Thread类；
     *     重写Thread类中的run方法，将相应的业务逻辑在run方法中实现；
     *     然后实例化一个自定义的线程对象后，必须通过调用start()来开启该线程，这样该线程才会和其他线程来抢占CPU资源；
     *     不能调用run()方法，调用run()方法相当于普通的实例对象方法调用，并不是多线程。
     ******************
     *  2、自定义一个类，实现Runnable接口；
     *     重写接口中的run方法，将相应的业务逻辑放在run方法中实现；
     *     然后实例化一个自定义的线程对象；
     *     再实例化一个Thread类的对象，将实例化的自定义线程类的对象传入构造Thread类的函数中
     *     然后使用Thread类的对象调用，start()方法.
     *
     *
     *  3、注意必须把子线程的任务放在主线程之后执行，否则主线程执行完成之后，才会执行子线程
     */
}

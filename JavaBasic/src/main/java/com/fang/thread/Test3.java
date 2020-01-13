package com.fang.thread;

public class Test3 {

    public static void main(String[] args) {
        /**
         * MyRunnable的使用与MyThread略有不同
         * MyRunnable相当于定义了线程的业务逻辑，
         * 但是它本身不是一个线程，所以需要实例化Thread类的对象作为线程。
         * 然后将MyRunnable对象赋给Thread对象，这样Thread就拥有了MyRunnable中定义的业务逻辑，
         * 再通过调用Thread对象的start方法来启动线程。
         */
        MyRunnable runnable = new MyRunnable();
        // 这里要把自定义的线程对象传入Thread构造方法中；否则自定义的线程类中的方法不会生效
        Thread thread = new Thread(runnable);
        thread.start();

        //主线程
        for(int i=0;i<100;i++){
            System.out.println("========Test3");
        }
    }
}

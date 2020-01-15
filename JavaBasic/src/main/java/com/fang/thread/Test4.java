package com.fang.thread;

public class Test4 {
    public static void main(String[] args) {
        A a = new A();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    a.test(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                    a.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class A{
    public synchronized void test(int i){
        if(i==5){
            try {
                this.wait(); // 阻塞(不传参数是永久阻塞；传参数是阻塞指定时间)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i+"----A");
    }

    public synchronized void test2() {
        this.notify(); // 唤醒上一个wait的线程
    }
}
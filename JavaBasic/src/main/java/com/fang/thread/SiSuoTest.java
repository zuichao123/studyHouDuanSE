package com.fang.thread;

public class SiSuoTest {
    public static void main(String[] args) {
        DeadLockRunnable dl = new DeadLockRunnable();
        dl.flag = 1;
        DeadLockRunnable dl2 = new DeadLockRunnable();
        dl2.flag = 2;

        new Thread(dl,"孙健 ").start();
        try {
            // 破解死锁的关键，线程休眠一会儿
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(dl2,"大哥 ").start();
    }
}

class DeadLockRunnable implements Runnable{
    public int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    @Override
    public void run() {
        if(flag == 1){
            System.out.println(Thread.currentThread().getName()+"获取的资源o1，等待获取资源o2");
            synchronized (o1) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName()+"执行完毕");
                }
            }
        }

        if(flag == 2){
            System.out.println(Thread.currentThread().getName()+"获取资源o2，等待获取资源o1");
            synchronized (o2) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"执行完毕");
                }
            }
        }

    }
}

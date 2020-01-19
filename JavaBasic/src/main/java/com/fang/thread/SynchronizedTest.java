package com.fang.thread;

/**
 * 使用synchronize关键字，修饰共享资源
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        /*Account account = new Account();
        Thread thread1 = new Thread(account, "线程1");
        Thread thread2 = new Thread(account, "线程2");
        thread1.start();// 线程1
        thread2.start();// 线程2*/

        /*for(int i=0; i<5; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            });
            thread.start();
        }*/

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SynchronizedTest sy = new SynchronizedTest();
                    sy.testCodePick();
                }
            });
            thread.start();
        }
    }

    /**
     * synchronized 修饰静态方法
     */
    public synchronized static void test() {
        System.out.println("start...");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }

    /**
     * synchronized 修饰实例方法中使用 synchronized 修饰同步代码块
     * synchronized(){}
     *  ()内部需要添加加锁的资源，静态方法数据类的方法，不属于任何一个实例对象，
     *  所有静态方法中的synchronized只能锁定类，不能锁定实例对象，this代表一个实例对象。
     */
    public void testCodePick(){
        synchronized (SynchronizedTest.class) {
            System.out.println("start.....");
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end.....");
        }
    }

}

class Account implements Runnable {
    private static int num; // 记录访问的次数

    @Override
    public synchronized void run() {
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "当前第" + num + "位访客");
    }
}

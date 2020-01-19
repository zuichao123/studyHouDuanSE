package com.fang.thread.examples;

public class MaiFangLizi {

    /**
     * 某楼盘摇号买房，分为普通好VIP号，50个普通号，10个VIP号
     * 普通号摇到10个时候，让VIP摇完后，再让普通号选
     * VIP是普通号选房时间的2倍
     */

    public static void main(String[] args) {
        VIPRunnable vip = new VIPRunnable(); // VIP购房对象
        Thread thread = new Thread(vip); // vip线程
        System.out.println(thread.getPriority()); // 线程等级
        thread.setPriority(Thread.NORM_PRIORITY + 3); // 提升等级
        thread.start();


        NormalRunnable nrmal = new NormalRunnable(); // 普通购房对象
        nrmal.setThread(thread); // 将VIP的线程设置给普通购房对象的属性线程中，当执行到10次的时候，VIP线程join()
        Thread thread2 = new Thread(nrmal); // 启动一个普通购房线程
        thread2.start();
    }
}

class NormalRunnable implements Runnable {
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("普通号" + i + "在选房");
            if (i == 10) {
                try {
                    thread.join(); // 线程合并 给 VIP线程独占
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.currentThread().sleep(1000); // 1秒选房时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class VIPRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("VIP号" + i + "选房");
            try {
                Thread.currentThread().sleep(2000); // 2秒选房时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


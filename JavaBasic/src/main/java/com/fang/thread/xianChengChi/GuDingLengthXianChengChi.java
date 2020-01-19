package com.fang.thread.xianChengChi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 实际开发中的方式
 * 创建一个长度固定的线程池
 */
public class GuDingLengthXianChengChi {
    public static void main(String[] args) {
        // 创建一个长度固定的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 12; i++) {
            // 开启是个线程，获取十个任务执行
            MyTask2 task2 = new MyTask2();
            service.execute(task2);
        }
        service.shutdown();

        // 这两种方式的写法一样（这种没有使用线程池，起一个执行一个）
//        for (int i = 0; i < 10; i++) {
//            MyTask2 task2 = new MyTask2();
//            new Thread(task2).start();
//        }
    }
}
class MyTask2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("* & *");
    }
}
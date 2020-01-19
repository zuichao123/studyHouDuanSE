package com.fang.thread.xianChengChi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池
 * 线程数可以达到Integer.MAX_VALUE, 2147483647 内部使用了SynchronousQueue作为阻塞队列。
 * 异步
 * 多个任务，多个线程
 */
public class CacheXianChengChi {


    public static void main(String[] args) {
        // 创建一个缓存线程池
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            // 开启是个线程，获取十个任务执行
            MyTask3 task3 = new MyTask3();
            service.execute(task3);
        }
        service.shutdown();

        // 这两种方式的写法一样（这种没有使用线程池，起一个执行一个）
//        for (int i = 0; i < 10; i++) {
//            MyTask2 task2 = new MyTask2();
//            new Thread(task2).start();
//        }
    }
}
class MyTask3 implements Runnable{
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

package com.fang.thread.xianChengChi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例线程池
 *      同步
 *      多个任务共用一个线程
 */
public class SingleXianChengChi {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            MyTask2 task2 = new MyTask2();
            service.execute(task2);
        }
        service.shutdown();
    }
}

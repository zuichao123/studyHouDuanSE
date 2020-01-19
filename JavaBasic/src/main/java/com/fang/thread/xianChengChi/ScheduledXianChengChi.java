package com.fang.thread.xianChengChi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 任务调度线程池
 *      每隔一个周期执行
 */
public class ScheduledXianChengChi {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        // 延迟5秒执行，每隔3秒执行一次任务
        service.scheduleAtFixedRate(new MyTask2(), 5, 3, TimeUnit.SECONDS);
        service.shutdown();
    }
}

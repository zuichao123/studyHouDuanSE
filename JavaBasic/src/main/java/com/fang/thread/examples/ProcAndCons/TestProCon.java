package com.fang.thread.examples.ProcAndCons;

public class TestProCon {
    public static void main(String[] args) {
        // 框是共享的，实例化一个框
        SyncStack syncStack = new SyncStack();
        // 生产者
        Produce produce = new Produce(syncStack); // 动作
        Produce produce2 = new Produce(syncStack);
        Produce produce3 = new Produce(syncStack);
        // 消费者
        Consumer consumer = new Consumer(syncStack); // 动作
        Consumer consumer2 = new Consumer(syncStack);

        new Thread(produce).start(); // 人
        new Thread(produce2).start();
        new Thread(produce3).start();
        new Thread(consumer).start(); // 人
        new Thread(consumer2).start();
    }
}

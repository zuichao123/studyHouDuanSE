package com.fang.thread.examples.ProcAndCons;

public class Produce implements Runnable{
    private SyncStack syncStack;
    public Produce(SyncStack syncStack){
        this.syncStack = syncStack;
    }
    @Override
    public void run() {
        for(int i=0; i<20; i++){
            Hamburger hamburger = new Hamburger(i);
            // 生产添加汉堡到数组中
            this.syncStack.push(hamburger);
            // 暂停线程一下，让消费者消费
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

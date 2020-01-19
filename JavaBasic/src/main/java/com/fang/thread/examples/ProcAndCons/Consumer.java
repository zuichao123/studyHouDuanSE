package com.fang.thread.examples.ProcAndCons;

public class Consumer implements Runnable {
    private SyncStack syncStack;
    public Consumer(SyncStack syncStack){
        this.syncStack = syncStack;
    }
    @Override
    public void run() {
        for(int i=0; i<20; i++){
            // 消费
            this.syncStack.pop();
            try {
                // 暂停一下，让生产者去生产
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

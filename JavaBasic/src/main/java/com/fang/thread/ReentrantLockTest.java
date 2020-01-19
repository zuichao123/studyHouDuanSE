package com.fang.thread;

/**
 * 重入锁
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock);
        Thread t2 = new Thread(timeLock);
        t1.start();
        t2.start();
    }
}

class TimeLock implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            // 判断3秒内是否可以获取锁
            if(reentrantLock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"获取了锁");
                Thread.currentThread().sleep(4000);
            }else {
                System.out.println(Thread.currentThread().getName()+"没有获取锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 解锁
            if(reentrantLock.isHeldByCurrentThread()){
                reentrantLock.unlock();
            }
        }
    }
}
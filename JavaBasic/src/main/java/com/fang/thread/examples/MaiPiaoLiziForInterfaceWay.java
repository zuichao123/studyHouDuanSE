package com.fang.thread.examples;

public class MaiPiaoLiziForInterfaceWay {

    /**
     * 多线程模拟网络购票
     * 游客、学生、代理共同抢15张票
     */
    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();
        Thread t1 = new Thread(ticketRunnable, "游客");
        Thread t2 = new Thread(ticketRunnable, "代理");
        Thread t3 = new Thread(ticketRunnable, "学生");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketRunnable implements Runnable {
    public int count = 15; // 总票数
    public int num = 0; // 已卖的

    @Override
    public void run() {
//        while (count > 0){
//            try {
//                Thread.currentThread().sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (TicketRunnable.class) {
//                if (count == 0){
//                    return;
//                }
//                count--;
//                num++;
//                System.out.println(Thread.currentThread().getName()+"抢到了票第"+num+"张票，  还剩"+count+"张票");
//            }
//        }

        // 或者 整体锁起来
        synchronized (TicketRunnable.class) {
            while (count > 0) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                num++;
                System.out.println(Thread.currentThread().getName() + "抢到了票第" + num + "张票，  还剩" + count + "张票");
            }
        }
    }
}


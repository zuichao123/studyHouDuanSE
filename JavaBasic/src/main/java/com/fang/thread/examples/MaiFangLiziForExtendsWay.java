package com.fang.thread.examples;

public class MaiFangLiziForExtendsWay {
    public static void main(String[] args) {
        TicketThread thread1 = new TicketThread();
        TicketThread thread2 = new TicketThread();
        TicketThread thread3 = new TicketThread();
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketThread extends Thread{
    public static int count = 15;
    public static int num = 0; //

    @Override
    public void run(){
        while (num < 15){
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TicketThread.class) {
                if (num == 15){
                    return;
                }
                count--;
                num++;
                System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票，  还剩"+count+"张票");
            }
        }
    }
}
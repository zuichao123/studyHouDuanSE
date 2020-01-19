package com.fang.thread.examples.ProcAndCons;

public class SyncStack {
    public Hamburger[] array = new Hamburger[6];
    public int index = 0;
    /**
     * 向容器中添加汉堡
     */
    public synchronized void push(Hamburger hamburger){
        // 如果数组装满了  wait  暂停
        while (index == array.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果不满，就唤醒继续装
        this.notify();
        array[index] = hamburger;
        index++;
        System.out.println("生产了一个汉堡："+hamburger);
     }

     /**
     * 从容器中取出汉堡
     */
    public synchronized Hamburger pop(){
        // 如果取得空了 wait 暂停
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果不空，就唤醒 notify 继续取
        this.notify();
        index--;
        System.out.println("消费了一个汉堡："+array[index]);
        return array[index];
    }
}

package com.fang.thread;

public class SyncStack {
    public Hamburger[] array = new Hamburger[6];
    public int index = 0;
    /**
     * 向容器中添加汉堡
     */
    public synchronized void push(Hamburger hamburger){
        array[index] = hamburger;
        index++;
        System.out.println("生产了一个汉堡："+hamburger);
    }
    /**
     * 从容器中取出汉堡
     */
    public synchronized Hamburger pop(){
        index--;
        System.out.println("取出了一个汉堡：");
        return array[index];
    }
}

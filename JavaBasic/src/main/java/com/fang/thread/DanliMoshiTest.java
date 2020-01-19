package com.fang.thread;

public class DanliMoshiTest {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance();
                }
            }).start();
        }
    }
}

class Singleton{
    /**
     * 完整的doublecheck写法
     * 多线程安全时的单例模式写法
     */
    private volatile static Singleton instance=null;
    private Singleton(){
        System.out.println("创建了Singleton对象");
    }
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

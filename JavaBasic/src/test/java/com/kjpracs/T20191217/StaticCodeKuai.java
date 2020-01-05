package com.kjpracs.T20191217;

public class StaticCodeKuai {
    public static final int MAX_INDEX;
    public final int fromIndex;

    static {
        // 当类被第一次调用时只执行一次
        System.out.println("执⾏ static 代码块");
        MAX_INDEX = 1000;
    }

    {
        // 当类构造实例时就调用执行一次
        System.out.println("执⾏初始化代码块");
        this.fromIndex = 1;
    }

    public static void main(String[] args) {
        // 静态代码块
        System.out.println(StaticCodeKuai.MAX_INDEX);

        StaticCodeKuai codeBlock = new StaticCodeKuai();
        System.out.println(codeBlock.fromIndex);

        StaticCodeKuai codeBlock2 = new StaticCodeKuai();
        System.out.println(codeBlock2.fromIndex);
    }

}

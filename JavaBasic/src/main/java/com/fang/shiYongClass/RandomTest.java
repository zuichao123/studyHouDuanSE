package com.fang.shiYongClass;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        /**
         * 无参构造
         */
        Random random = new Random();
        for (int i = 0; i <= 3; i++) {
            /**
             * 随机生成一个Boolean的值
             */
            boolean flag = random.nextBoolean();
            System.out.println(flag);
        }
        for(int i=0; i<=10; i++){
            double num = random.nextDouble();
            System.out.println("第"+i+"个随机数是"+num);
        }
        for (int i = 0; i <= 10; i++) {
            float num = random.nextFloat();
            System.out.println("第"+i+"个随机数是"+num);
        }
        for (int i = 0; i <=10; i++) {
            int num = random.nextInt();
            System.out.println("第"+i+"个随机数是"+num);
        }
        for (int i = 0; i <=10; i++) {
            long num = random.nextLong();
            System.out.println("第"+i+"个随机数是"+num);
        }
    }
}

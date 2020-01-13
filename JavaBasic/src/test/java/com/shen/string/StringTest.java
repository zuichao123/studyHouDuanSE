package com.shen.string;

import org.testng.annotations.Test;

public class StringTest {
    @Test
    public void testOp3(){
        long start = System.currentTimeMillis();
        String str = "";
        for(int i=0; i<20000; i++){
            str += i;
        }
        System.out.printf(String.valueOf(str.length()));
        System.out.printf(String.format("耗时：%d ms", System.currentTimeMillis() - start));

        // jvm 优化后
        long start1 = System.currentTimeMillis();
        String str1 = "";
        for(int i=0; i<20000; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str1);
            sb.append(i);
            str1 = sb.toString();
        }
        System.out.printf(String.valueOf(str1.length()));
        System.out.printf(String.format("耗时：%d ms", System.currentTimeMillis() - start1));

        // 最优化的
        long start2 = System.currentTimeMillis();
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<20000; i++){
            sb.append(str2);
            sb.append(i);
        }
        System.out.printf(String.valueOf(sb.length()));
        System.out.printf(String.format("耗时：%d ms", System.currentTimeMillis() - start2));
    }

}

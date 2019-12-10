package com.sunjian.flow;

import com.sunjian.flow.AgeCheck;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CodeDemo {

    @Test
    public void testIfElse(){
        int age = 10;
        if(age < 7){
            System.out.printf(age + "岁，属于儿童");
        }else if(age < 18){
            System.out.printf(age + "岁，属于少年");

        }else if(age < 41){
            System.out.printf(age + "岁，属于中青年");
        }else if(age < 60){
            System.out.printf(age + "岁，属于老年");
        }
    }

    @Test
    public void testWhile(){
        boolean flag = true;
        int times = 0;
        while (flag){
            int r = new Random().nextInt(1000);
            if(r % 30 == 0){
                flag = false;
                System.out.printf(r+"可以被30整除，退出循环！---------"+"\n");
            }else {
                System.out.printf(r +"不能被30整除！========"+"\n");
                times++;
            }
        }
        System.out.printf("随机产生了"+times+"不能被整除的数！");
    }

    @Test
    public void testDoWhile(){
        boolean flag = true;
        int times = 0;
        do{
            int r = new Random().nextInt(1000);
            if(r % 30 == 0){
                flag = false;
                System.out.printf(r+"可以被30整除，退出循环！---------"+"\n");
            }else {
                System.out.printf(r +"不能被30整除！========"+"\n");
                times++;
            }
        }while (flag);
        System.out.printf("随机产生了"+times+"不能被整除的数！");
    }

    @Test
    public void testFor(){
        //打印0-100范围内的单数，并计算总个数
        int count = 0;
        for(int i=0; i<=100; i++){
            if(i%2 != 0){
                System.out.printf(i+"是单数\n");
                count++;
            }
        }
        System.out.printf("总个数是："+count);
    }

    @Test
    public void testSwitch(){
        //机器人指令
        switch (9){
            case 1:
                System.out.printf("掃地");
                break;
            case 2:
                System.out.printf("開燈");
                break;
            case 3:
                System.out.printf("關燈");
                break;
            case 4:
                System.out.printf("播放音樂");
                break;
            case 5:
                System.out.printf("停止音樂");
                break;
            default:
                System.out.printf("無法識別");
                break;
        }
    }

    @Test
    public void testBreak(){
        int count = 0;
        while (true){
            int r = new Random().nextInt(1000);
            if(r % 30 != 0){
                System.out.printf(r +"不能被30整除！========"+"\n");
                count++;
            }else {
                System.out.printf(r+"可以被30整除，退出循环！---------"+"\n");
                break;
            }
        }
        System.out.printf("---隨機數中不能整除30的數有---"+count+"個");
    }

    int getMaxNumRem7(int n1, int n2){
        for(int n=n2; n>0; n--){
            if (n%n1 == 7){
                return n;
            }
        }
        return -1;
    }
    @Test
    public void testReturn(){
        int r = getMaxNumRem7(10, 1000);
        System.out.printf("----"+r);
    }

    @Test
    public void testContinue(){
        //0-100之間被7整除的數
        int count = 0;
        for (int i=0; i<=100; i++){
            if(i%7 != 0){
                continue;
            }
            System.out.printf(i+"能被7整除\n");
            count++;
        }
        System.out.printf(count+"個數能被7整除");
    }

    @Test
    public void testAgeCheck1(){
        //斷言測試
        Assert.assertEquals(AgeCheck.getAgeName(6),"兒童");
        Assert.assertEquals(AgeCheck.getAgeName(17),"少年");
        Assert.assertEquals(AgeCheck.getAgeName(40),"青年");
        Assert.assertEquals(AgeCheck.getAgeName(58),"老年");
        Assert.assertEquals(AgeCheck.getAgeName(85),"老年");
    }
}

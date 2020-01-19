package com.shen.array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayGuDingLengthXianChengChi {
    int[] arr1 = {1,2,3,4,5,6,7,8};
    int[] arr2 = {1,2,3,4,5,6,7,8};

    @Test
    public void testCopyArray(){
        // 1、来源 2、起始位置 3、目的 4、结束位置 5、拷贝长度
        System.arraycopy(arr1, 1, arr2, 4, 3);
        for(int i=0;i<arr2.length;i++){
            System.out.printf(arr2[i]+"");
        }
    }

    @Test
    public void testDuoWeiShuZu(){
        String [][] users = new String[5][];
        users[0] = new String[4];
        users[0][0] = "001";
        users[0][1] = "张三";
        users[0][2] = "男";
        users[0][3] = "25";

        users[1] = new String[3];
        users[1][0] = "002";
        users[1][1] = "王五";
        users[1][2] = "女";
//        users[1][3] = "未知";

        for(String[] user:users){
            System.out.printf(Arrays.toString(user));
        }
        System.out.printf("");
        Arrays.asList(users).forEach(user -> System.out.printf(Arrays.toString(user)));
    }

    public int[] twoSum(int[] intArray, int target){
        for(int i = 0; i<intArray.length-1; i++){
            for(int j=i+1; j<intArray.length; j++){
                System.out.printf("");
            }
        }
        return intArray;
    }

    @Test
    public void testTwoSum(){
        int[] intArray = {2,7,11,15};
        int target = 9;
        System.out.printf(Arrays.toString(twoSum(intArray, target)));
    }
}

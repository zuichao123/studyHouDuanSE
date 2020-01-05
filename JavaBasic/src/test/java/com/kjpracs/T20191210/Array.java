package com.kjpracs.T20191210;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.arraycopy;

public class Array {
    public static void main(String[] args) {
        // 数组遍历
        Integer[] arr = {1,2,5,3,6};

        System.out.println("for循环使用数组下标：");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();

        System.out.println("for each循环：");
        for(Integer a : arr){
            System.out.print(a);
        }
        System.out.println();

        System.out.println("lambda表达式：");
        Arrays.asList(arr).forEach(numb -> System.out.print(numb));
        System.out.println();

        int[] arr2 = {1,2,5,3,6};
        System.out.println("lambda表达式：");
        Arrays.asList(arr).forEach(numb -> System.out.print(numb));

        int[] n = new int[] {1, 2, 3};
        System.out.println(n[2]+"");

        // 数组值替换
        int[] n2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        plus1ForEvenIndex(n2);
        System.out.println(Arrays.toString(n2));

        // 数组拷贝
        String[] str = {"02","03","04","05","11","00"};
        String[] str1 = {"22","33","44","55","66","77"};
        copyOf(str);
        copyOfRange(str);

        // 从str的第3位开始复制给str1的第3位开始，覆盖3个
        arraycopy(str, 2, str1, 2,3);
        System.out.println(Arrays.toString(str1));

        // 数组填充
        Arrays.fill(str, "w");
        System.out.println(Arrays.toString(str));
        Arrays.fill(str, str.length-1, str.length, "s"); // 数组的最后一位填充为s
        System.out.println(Arrays.toString(str));


        // 数组排序
        int arr3[] = new int[100];
        for (int index = 0; index < arr3.length; index++) {
            arr3[index] = new Random().nextInt(100);
        }
        System.out.println("排序前：" + Arrays.toString(arr3));
        Arrays.sort(arr3);
        System.out.println("排序后：" + Arrays.toString(arr3));

        // asList


        // binarySerach

    }

    private static void plus1ForEvenIndex(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            if ((index + 1) % 2 == 0) {
                arr[index] = arr[index] + 1;
            }
        }
    }

    private static void copyOf(String[] arr){
        // 拷贝数组，参数一：指定数组；参数而：拷贝位数；
        String[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr2));
    }
    private static void copyOfRange(String[] arr){
        // 拷⻉数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
        String[] arr2 = Arrays.copyOfRange(arr, 1, 3);
        System.out.println(Arrays.toString(arr2));
    }
}

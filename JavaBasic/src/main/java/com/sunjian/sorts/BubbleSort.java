package com.sunjian.sorts;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {33, 1, 42, 3, 24, 5};

        System.out.println("排序前：");
        printSort(arr);
        bubbleSort(arr);
        System.out.println("\n排序后：");
        printSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int tmp;
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static void printSort(int[] arr) {
        for (int ii = 0; ii < arr.length; ii++) {
            System.out.print(arr[ii] + "\t");
        }
    }
}

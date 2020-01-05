package com.kjpracs.T20191129;

public class DataType {
    public static void main(String[] args) {
        Integer num1 = 127;
        Integer num2 = 127;
        System.out.println(num1 == num2); // true

        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4); // false

        Integer num5 = 127;
        Integer num6 = new Integer(127); // false
        System.out.println(num5 == num6);

        int num7 = 128;
        Integer num8 = 128;
        System.out.println(num7 == num8); // true

        Double d1 = 127D;
        Double d2 = 127D;
        System.out.println(d1 == d2); // false

        Double d3 = 128D;
        Double d4 = 128D;
        System.out.println(d3 == d4); // false

        System.out.println(2 * 0.1 == 0.2); // true1
        System.out.println(3 * 0.1 == 0.3); // false 0.30000000000000004 != 0.3
    }
}

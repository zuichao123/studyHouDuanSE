package com.fang.shiYongClass;

public class MathTest {
    public static void main(String[] args) {
        // π
        System.out.println(Math.PI);

        // 常量
        System.out.println(Math.E);

        // 平方根
        System.out.println(Math.sqrt(9));

        // 立方根
        System.out.println(Math.cbrt(8));

        // 求x的y次方
        System.out.println(Math.pow(2, 3));

        // 求num1和num2中的最大值
        System.out.println(Math.max(2, 8));

        // 求num1和num2的最小值
        System.out.println(Math.min(2, 8));

        // 求小于num的最大整数
        System.out.println(Math.floor(4.01));

        // 求大于num的最小整数
        System.out.println(Math.ceil(4.9));
        System.out.println(Math.ceil(4.001));

        // 四舍五入
        System.out.println(Math.rint(4.6));
        System.out.println(Math.rint(4.6f));

        System.out.println(Math.round(5.7));
        System.out.println(Math.round(5.7f));

        // 随机数( 生成一个大于等于0.0 且小于1.0的随机数 )
        System.out.println(Math.random());
    }
}

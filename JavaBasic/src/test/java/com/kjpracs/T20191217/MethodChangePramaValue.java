package com.kjpracs.T20191217;

public class MethodChangePramaValue {

    public static void main(String[] args) {

        // ⼀个⽅法不能修改⼀个基本数据类型的参数，也不能修改引⽤类型参数的指向，但是却可以修改引⽤类型参数
        //指向的对象的值
        int n = 100;
        System.out.println(n); // 100
        changePrimitiveValue(n);
        System.out.println(n); // 100

        StringBuilder sb = new StringBuilder();
        sb.append("this is a String");
        System.out.println(sb.toString());
        changeReferenceValue(sb);
        System.out.println(sb.toString()); // this is a String New
    }
    private static void changePrimitiveValue(int n){
        n = 200;
    }
    private static void changeReferenceValue(StringBuilder sb){
        sb.append(" New");
        sb = new StringBuilder();
        sb.append("NewValue");
    }
}

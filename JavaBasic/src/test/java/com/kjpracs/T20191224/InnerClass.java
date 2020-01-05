package com.kjpracs.T20191224;

public class InnerClass {

    public class InnerClass2 {

    }
    public InnerClass2 createInnerClass(){
        return new InnerClass2();
    }

    public static void main(String[] args) {
        InnerClass in = new InnerClass();

        InnerClass.InnerClass2 n1 = in.createInnerClass();
        InnerClass.InnerClass2 n2 = in.new InnerClass2();
    }
}

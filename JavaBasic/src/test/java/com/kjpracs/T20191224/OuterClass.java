package com.kjpracs.T20191224;

public class OuterClass {
    private Integer index;
    private String name;

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }

    public class InnerClass {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void printName() {
            System.out.println(name);
            System.out.println("我的外围类Name=" + OuterClass.this.name);
            System.out.println("我的外围类Index=" + index);
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.setIndex(1);
        oc.setName("我是外围类");
        oc.printName();

        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.setName("我是内部类");
        ic.printName();
    }
}

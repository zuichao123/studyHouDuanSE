package com.sunjian.collection;

import java.util.*;
/*20191231*/
public class SetSimpleUse {
    public static void main(String[] args) {
        // Set，集，不能有重复元素，可以有null，可能有序或无序
            // HashSet 无序
            // TreeSet 有序
            // LinkedHashSet，EnumSet...

        // 所有的集，都实现了Set接口，而Set接口继承自Collection
        // 所以可以说所有的集都实现了Collection
        // Set和Collection接口的方法是完全一样的，仅是用于语义上的用途
        HashSet<String> set = new HashSet<>();

        // 添加
        set.add("b");
        set.add("a");
        set.add("f");
        set.add("d");
        set.add("c");
        set.add("e");

        // 迭代器遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

        // List有序，指的是按插入顺序来保存元素
        // TreeSet有序，指定是元素按照一定规则来排序，Comparator接口
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("5");
        set2.add("1");
        set2.add("4");
        set2.add("2");
        set2.add("3");
        Iterator<String> iterator1 = set2.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next());
        }

        //
        LinkedHashSet<String> set3 = new LinkedHashSet<>();
        set3.add("1");
        set3.add("2");
        set3.add("3");
        set3.add("4");
        set3.add("5");
        Iterator<String> iterator2 = set3.iterator();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next());
        }

        // 删除


        /*
        *   如果需要使用HashSet的查找元素的高性能
        *   同时又需要按元素插入顺序来排序
        *   LinkedHashSet
        * */
    }
}


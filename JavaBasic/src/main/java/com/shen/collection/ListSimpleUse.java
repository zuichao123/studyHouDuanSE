package com.shen.collection;

import java.util.*;

/*20191231*/
public class ListSimpleUse {
    public static void main(String[] args) {
        // 集合分为两大类：
            // 1、单个元素的序列，全部都实现了Collection接口
                // 1.1、List，有序的按照插入顺序排序，可以有重复的元素
                // 1.2、Set，集，不可以有重复元素，可以包含 null
                // 1.3、Queue，队列，按一定规则进行添加/删除
            // 2、键值对，全部都实现了Map接口

        // 可以通过尖括号来指定列表里要放的元素的类型
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("F");
        printElement(list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        printElement(list2);

        List<Object> list3 = new ArrayList<>();
        list3.add(1);
        list3.add("字符串");
        list3.add(new Date());
        list3.add(new ListSimpleUse().new CustomClass());
        // 如果需要进行强制数据类型转换时，需要使用instanceof来判断该变量的实际类型
        for(int i=0; i<list3.size(); i++){
            Object obj = list3.get(i);
            if(obj instanceof String){
                String str = (String) obj;
                System.out.println("字符串数值："+str);
            }else if(obj instanceof Integer){
                Integer n = (Integer) obj;
                System.out.println("int型数值："+n);
            }else if(obj instanceof Date){
                Date d = (Date) obj;
                System.out.println("日期型数字："+d);
            } else {
                System.out.println("不支持的类型："+obj.getClass().toString());
            }
        }
    }

    private static void printElement(List<String> list) {
        System.out.println("list的元素的个数："+list.size());

        System.out.printf("使用for each遍历元素：");
        for(String s:list){
            System.out.print(s+",");
        }
        System.out.println("");

        System.out.printf("使用for循环遍历元素：");
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            System.out.print(str+",");
        }
        System.out.println("");

        System.out.printf("使用iterator迭代器遍历元素");
        Iterator<String> iterator = list.iterator();
        // 迭代器的位置是在元素之间
        // 存在 n 个元素的列表，迭代器的位置可能存在 n+1个
        // 获取迭代器后，迭代器的位置在第一个元素之前
        // 未调用next()方法时，调用remove()方法，抛IllegalStateException异常
        // remove()方法删除的是调用next()方法时返回的元素（越过的元素）
        // 当迭代器达到最后一个元素之后时，再调用next()方法，抛NoSuchElementException异常
        while (iterator.hasNext()){
            // next()方法有两个作用
                // 1、将迭代器的位置移动至下一个位置
                // 2、同时返回越过的元素
            String str = iterator.next();
            System.out.printf(str+",");
        }

        // list 删除
        System.out.println("");
        list.remove(1);
        list.remove("B");
        System.out.println("删除后的："+list);

        // 基本类型int删除时，也是根据角标删除的不是值
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.remove(3);
        System.out.println(list4);
    }

    // 继承链
        /*
        *   A -> B -> C -> D
        *   从子类的角度来看，它的所有父类都是它的继承链上的对象
        *   从C来看：C、B、A是C继承链上的对象
        *   从B来看：B、A是B继承链上的对象
        *
        *   instanceof判断的是自己是否实现了继承链上的对象
        *
        *   instanceof判断的是自己继承链上对象是否实现了某个接口
        * */

    private class CustomClass {
    }

}

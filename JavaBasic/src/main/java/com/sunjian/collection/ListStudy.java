package com.sunjian.collection;

import java.util.*;

/**
 * List 主要有两种：ArrayList 和 LinkedList
 * ArrayList：内部是使用数组来实现的
 * LinkedList：内部使用的是一个双向链表来实现
 *
 * 创建：无参数构建；有参数构造  1 指定容量大小 2 复制已存在的List来创建
 * 添加：1 头插 2 尾插 3 中间插入
 * 删除：1 头删 2 尾删 3 中间删除
 * 遍历：
 *      1 使用for循环
 *      2 使用迭代器 Iterator  ListIterator（前后都可以移动）
 *      3 使用迭代器对List进行添加、删除操作
 *      4 迭代器的使用注意事项：
 *          1 在使用迭代器对列表进行操作时，源对象不能发生结构性变化，否则迭代器操作会抛异常
 *  底层实现原理及主要JDK源码：内部存储结构、添加/删除/遍历操作的流程
 *  对List 进行排序：冒泡、插入、选择
 */

public class ListStudy {

    /*
    * 对原来的list结构修改后，需要重新获取新的list对象
    *
    * 遍历：
    *   1、使用for循环
    *   2、使用迭代器Iterator/ListIterator（双向迭代器）
    *   3、使用迭代器对List进行添加、删除操作
    *   4、迭代器的使用注意事项：
    *       在使用迭代器对列表进行操作时，原对象不能发生结构性变化（add/remove等），否则迭代器操作会抛异常。
    * */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> listIterator = list.listIterator();
        System.out.println("hasPrevioud=" + listIterator.hasPrevious());
        System.out.println("hasNext=" + listIterator.hasNext());
        System.out.println("previousIndex=" + listIterator.hasNext());

        studyLinkedList();
        // ArrayLinkedList 和 ArrayList区别
            // ArrayList 长于随机快速访问，而从列表中间删除/插入元素很慢
            // LinkedList 长于从列表中间删除/插入，但随机访问很慢
            // 随机访问：list.get(index), 通过索引来访问

        List<Integer> list2 = new LinkedList<>();
        listOpTime(list2);
    }

    private static void testListOpTime(List list, int times){
        for(int i=0; i<times; i++){
            list.add("A");
        }
        // 在索引为10的位置处插入10000个B，并计算耗时
        long start = System.currentTimeMillis();
        for(int i=0; i<times; i++){
            list.add(10, "B");
        }
    }


    private  static void listOpTime(List<Integer> list){
        int times = 100000;

        // for 循环遍历  每次get(index) 操作都会从头开始查找所以耗时大；但是如果i > length/2 会从后往前找
        long start = System.currentTimeMillis();
        for(int i=0; i<times; i++){
            list.get(i);
        }
        System.out.printf("[%s] for循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis()-start);

        // Iterator
        start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        System.out.printf("[%s] Iterator循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis()-start);

        // for-each
        start = System.currentTimeMillis();
        for(Integer n:list){

        }
        System.out.printf("[%s] for-each循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis()-start);


    }

    public static void studyLinkedList(){
        // 链表创建的时候不需要指定容量大小，因为它没有大小限制
        List list1 = new LinkedList();
        list1.add("A");
        list1.add("B");

        System.out.println(list1);
        List list2 = new LinkedList(list1);
        System.out.println(list2);

    }
}

package com.fang.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        // addAll 向集合中添加元素，个数没有限制
//        Collections.addAll(list,"jack", 31, "shen",32,true,'s');
        Collections.addAll(list,"jack", 31, "shen",32);
        System.out.println(list);

        // reverse 将集合中的元素进行反转
        Collections.reverse(list);
        System.out.println("反转之后"+list);

        // binarySearch 检索元素在集合中的位置，若结果大于等于0则表示在集合中；
        //              若结果小于0则表示集合中不存在
        //              集合中的类型要一致，并且按照升序进行排序
        int index = Collections.binarySearch(list, "shen");
        System.out.println(index);

        // replaceAll 替换集合中的内容
        Collections.replaceAll(list, "jack", "collections");
        System.out.println(list);

        // sort 对集合进行排序
        ArrayList list2 = new ArrayList();
        Collections.addAll(list2,1,3,5,6,2);
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);

        // 自定义排序规则
        MyCom mc = new MyCom();
        Collections.sort(list2,mc);
        System.out.println(list2);

        // swap 交换指定位置的元素
        Collections.swap(list2, 1, 2); // 第一个位置的和第二个位置的交换
        System.out.println(list2);
    }
}

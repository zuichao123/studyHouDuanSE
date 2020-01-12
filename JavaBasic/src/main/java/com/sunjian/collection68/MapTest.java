package com.sunjian.collection68;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        // 实例化Map对象
        HashMap<String, String> hashMap = new HashMap<>();
        // 添加元素
        hashMap.put("k1", "java");
        hashMap.put("k2", "java2");
        hashMap.put("k3", "java3");
        System.out.println(hashMap);

        // 取出元素,只能通过key值取出value值
        Set keys = hashMap.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()){
            System.out.println(hashMap.get(it.next()));
        }

        // 取出所有的values值
        Collection collection = hashMap.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 判断指定的key或者value是否存在
        boolean flag = hashMap.containsKey("k1");
        if(flag)
            System.out.println("存在k1");

        boolean flag2 = hashMap.containsValue("java");
        if (flag2)
            System.out.println("存在java");

        // hashtable
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashMap.put("k1", "hello");
        hashMap.put("k2", "hello2");
        hashMap.put("k3", "hello3");
        System.out.println(hashtable.get("k3"));
        hashtable.keySet();
        hashtable.values();
    }
    /**
     * Hashtable: jdk1.0
     *      安全性较高，性能较差
     * HashMap:
     *      线程不安全，性能较高
     *
     * Vector：线程安全，安全性高，性能较差
     *
     * ArrayList：线程不安全，安全性较差，性能较高
     */
}

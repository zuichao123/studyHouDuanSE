package com.fang.collection;

import com.shen.entity.User;

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

        // TreeMap
        TreeMap<String, String> map = new TreeMap<>();
        map.put("g", "hellow");
        map.put("b", "bbb");
        map.put("e", "eeelow");
        map.put("d", "dddlow");
        map.put("f", "ddddfff");
        Set keys2 = map.keySet();
        Iterator it2 = keys2.iterator();
        while (it2.hasNext()){
            String str = (String) it2.next();
            System.out.println(str+":"+map.get(str));
        }
        TreeMap<User, String> map1=new TreeMap<User, String>();
        map1.put(new User("张三", 1), "张三");
        map1.put(new User("张三", 2), "张三2");
        map1.put(new User("张三", 3), "张三3");
        Set keys3 = map1.keySet();
        Iterator iterator1 = keys3.iterator();
        while (iterator1.hasNext()){
            User user = (User) iterator1.next();
            System.out.println(user+"\t\t"+map1.get(user) );
        }

        // WeakHashMapTest
        WeakHashMap<String, String> map2 = new WeakHashMap<>();
        map2.put("a","java");
        map2.put("b","java2");
        map2.put("c","java3");
        map2.put("d","java4");
        System.out.println(map2.get("c"));
        System.gc();
        map2.put("h","java6");
        System.out.println(map2);
    }
    /**
     * Hashtable: jdk1.0
     *      安全性较高，性能较差，无序
     * HashMap：（常用，直接往里装，存取性能最高）
     *      线程不安全，性能较高，无序
     *
     * Vector：线程安全，安全性高，性能较差
     *
     * ArrayList：线程不安全，安全性较差，性能较高
     *
     * TreeMap：（ 常用，存的时候要排序，所有存取性能比hashMap低）
     *      按key排序--如果key值是一个自定义数类型，择该类必须实现comparable，并且实现compareTo方法，在该方法中定义当前类对象的排序规则
     *
     * WeakHashMap：
     *      垃圾回收
     *
     *
     * 总结：
     *      HashMap：存储一组无效，并且key值不可以重复的数据
     *      HashTable：存储一组无序，并且key值不可重复的数据，Hashtable的使用与HashMap基本一致
     *                 ，区别在于Hashtable是线程安全的，性能较低，HashMap是非线程安全的，性能较高。
     *      TreeMap：存储一组有序，并且key值不可重复的数据，这里的有序是指集合会自动根据key值对元素
     *               进行排序，默认是按照升序的方式排列，准确的说是对key值进行升序排序。
     */
}

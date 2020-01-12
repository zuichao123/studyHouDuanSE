package com.sunjian.collection68;

import com.sunjian.entity.Dog;

import java.util.*;

public class ListAndSetTest {
    public static void main(String[] args) {
//        arrayListTest();
//        linkedListTest();
        hashSetTest();
        linkedHashSetTest();
    }

    /**
     * 有序（存储时的顺序）
     * 不可重复
     */
    private static void linkedHashSetTest() {
        LinkedHashSet set = new LinkedHashSet();
        set.add(new Dog("旺财", "黑背"));
        Dog newDog = new Dog("小黑", "牧羊犬");
        set.add(newDog);
        set.add(new Dog("大黑", "笨狗"));
        set.add(new Dog("黑大", "笨狗2"));
        System.out.println("\n共计："+set.size()+"条狗");
        Iterator it =  set.iterator();
        while (it.hasNext()){
            Dog dog = (Dog) it.next();
            System.out.print(dog.getName()+"="+dog.getBrand()+"\t\t");
        }
    }

    /**
     * 无序
     * 不可重复
     */
    private static void hashSetTest() {
        HashSet set = new HashSet();
        set.add(new Dog("旺财", "黑背"));
        Dog newDog = new Dog("小黑", "牧羊犬");
        set.add(newDog);
        set.add(new Dog("大黑", "笨狗"));
        set.add(new Dog("黑大", "笨狗2"));
        System.out.println("共计："+set.size()+"条狗");
        Iterator it =  set.iterator();
        while (it.hasNext()){
            Dog dog = (Dog) it.next();
            System.out.print(dog.getName()+"="+dog.getBrand()+"\t\t");
        }

    }

    /**
     * 旨在元素的增加、删除
     */
    private static void linkedListTest() {
        LinkedList list = new LinkedList();
        Dog dog4 = new Dog("小黑4", "牧羊犬4");
        list.add(new Dog("小黑", "牧羊犬"));
        list.add(new Dog("小黑2", "牧羊犬2"));
        list.add(new Dog("小黑3", "牧羊犬3"));
        list.add(dog4);

        System.out.println("集合头部Dog:");
        Dog firstDog = (Dog) list.getFirst();
        System.out.println(firstDog.getName()+","+firstDog.getBrand()+"\t\t");

        System.out.println("集合的尾部dog：");
        Dog endDog = (Dog) list.getLast();
        System.out.println(endDog.getName()+","+endDog.getBrand()+"\t\t");

        System.out.println("向集合的头部添加Dog：");
        list.addFirst(new Dog("小新", "斑点狗"));
        for(int i=0;i<list.size(); i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+","+dog.getBrand()+"\t\t");
        }

        System.out.println("\n向集合的尾部添加Dog：");
        list.addLast(new Dog("新小", "黑狗"));
        for(int i=0;i<list.size();i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+"-"+dog.getBrand()+"\t\t");
        }

        System.out.println("\n移除集合头部的Dog：");
        list.removeFirst();
        for(int i=0;i<list.size();i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+"-"+dog.getBrand()+"\t\t");
        }

        System.out.println("\n移除集合尾部的Dog：");
        list.removeLast();
        for(int i=0;i<list.size();i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+"-"+dog.getBrand()+"\t\t");
        }
    }

    /**
     * 旨在元素的查找
     */
    private static void arrayListTest() {
        //        System.out.println("请输入4个狗：");
        ArrayList list = new ArrayList();
//        Scanner scanner = new Scanner(System.in);
//        for(int i=0; i<4; i++){
//            System.out.println("请输入Dog的名字：");
//            String name = scanner.next();
//            System.out.println("请输入Dog的品种");
//            String brand = scanner.next();
//
//            Dog dog = new Dog(name, brand);
//            list.add(dog);
//        }
        Dog dog4 = new Dog("小黑4", "牧羊犬4");
        list.add(new Dog("小黑", "牧羊犬"));
        list.add(new Dog("小黑2", "牧羊犬2"));
        list.add(new Dog("小黑3", "牧羊犬3"));
        list.add(dog4);

        System.out.println("共计："+list.size()+"条狗");

        for(int i=0;i<list.size(); i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+dog.getBrand()+"\t\t");
        }

        System.out.println("\n-------操作-------");
        System.out.print("删除第一个后");
        list.remove(1);
        System.out.println(" 还有："+list.size()+"条狗");
        for(int i=0;i<list.size(); i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+dog.getBrand()+"\t\t");
        }

        list.remove(dog4);
        System.out.print("\n删除小黑4后");
        System.out.println(" 还有："+list.size()+"条狗");
        for(int i=0;i<list.size(); i++){
            Dog dog = (Dog) list.get(i);
            System.out.print(dog.getName()+dog.getBrand()+"\t\t");
        }

        System.out.println("\n判断大黄是否存在");
        boolean flag = list.contains(new Dog("大黄", "藏獒"));
        if(flag){
            System.out.println("大黄在");
        }else {
            System.out.println("大黄不在@");
        }
    }
}

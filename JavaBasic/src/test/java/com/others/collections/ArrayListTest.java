package com.others.collections;

import com.others.entitys.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 练习
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();

        list.add(new Person("shen", 30));
        list.add(new Person("sunjian2", 32));
        list.add(new Person("sunjian2", 32));
        list.add(new Person("sunjian3", 33));
        list.add(new Person("sunjian3", 33));
        list.add(new Person("sunjian4", 34));
        list.add(new Person("sunjian4", 34));
        list.add(new Person("sunjian4", 34));

        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()){
            Person p = iterator.next();
            System.out.println(p.toString());
        }

        System.out.println("-------------");
        System.out.println(getSingleArrayList(list));

    }

    /**
     * arrayList复制
     * @param list
     * @return
     */
    private static ArrayList getSingleArrayList(ArrayList<Person> list) {

        ArrayList temp = new ArrayList();

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            if(!temp.contains(obj)){
                temp.add(obj);
            }
        }

        return temp;
    }
}

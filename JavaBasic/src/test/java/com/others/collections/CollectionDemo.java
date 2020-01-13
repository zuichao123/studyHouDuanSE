package com.others.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();

        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();

        show(c1, c2);
        show(c1);
    }

    private static void show(Collection c1, Collection c2) {
        c1.add("c1-1");
        c1.add("c1-2");
        c1.add("c1-3");

        c2.add("c2-1");
        c2.add("c1-2");
        c2.add("c2-3");

        System.out.println("将c2添加到c1集合中=" + c1.add(c2));
        System.out.println(c1);

        System.out.println("两个集合的交集="+c1.retainAll(c2)); // 执行这句后，c1集合中只剩下与c2交集的对象了
//        System.out.println("c2包含c1的内容="+c2.contains(c1));

        System.out.println(c1); // [c1-2]
        System.out.println(c2); // [c2-1, c1-2, c2-3]

        for(Iterator it = c1.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }

    private static void show (Collection c){
        c.add("aa1");
        c.add("aa2");
        c.add("aa3");

        c.remove("aa2");
//        c.clear();
        System.out.println(c.contains("aa2"));
        System.out.println(c);
    }
}

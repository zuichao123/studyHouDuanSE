package com.fang.reflect;

/**
 * 反射
 *
 * 显示生活中的反射如通过镜子可以反射出你的样子，
 * 水面可以反射出物体的形态等等，无论是哪种反射，
 * 都是通过一个虚像映射到实物，这样我们就可以获取到实物的某些形态特征。
 *
 * 程序中的反射也是同样的道理，它完成的是通过一个实例化对象映射到对应的类，
 * 在程序运行期间我们可以通过一个对象获取到该对象对应的类信息。
 *
 * 一句话简单理解反射：
 * 正常情况下我们通过类来创建实例化对象，反射就是将这一过程进行反转，通过实例化对象类获取类的信息。
 */

/**
 * Class类
 * Class类是反射的源头，类的信息在java中如何描述？java也是将类的信息抽象成一个对象，Class类就是用来创建描述类信息的对象的。
 * Calss类是专门用来描述其他类的类，Class类的每一个实例化对象对应的都是其他类的结构特征（成员变量、方法、构造函数、父类、实现的接口）。
 *
 * Class对象不能通过构造函数来创建，因为Class只有一个private的构造函数，外包无法直接调用。
 * 3中创建方式：
 *      1、调用Class类的静态方法forName(String className)创建，className是目标类的全类名；
 *      2、通过目标类的class创建，java中的每一个类都可以调用类.class，这里的class不是属性，叫做“类字面量”，其作用是获取在内存中该类型Class对象的引用。
 *      3、通过目标类的实例化对象getClass()方法创建，getClass()是Object类中定义的方法，被所有的子类所继承，java中的每一个类都可以调用getClass()方法，获取内存中该类的Class对象的引用。
 *
 * 每个目标类在内存中的Class对象（该类的运行时类）只有一份，即clazz 和 clazz2 clazz3 所指向的引用对象是同一个。
 * 通过Class对象可以获取到目标类的结构，成员变量，方法，构造函数，父类，实现的接口等等。
 */

public class ReflectTest {
    public static void main(String[] args) {
//        forNameTest();
//        classTest();
        getClassTest();
    }

    /**
     * 方式三
     */
    private static void getClassTest() {
        Person person = new Person();
        Class clazz = person.getClass();
        System.out.println(clazz);
    }

    /**
     * 方式二
     */
    private static void classTest() {
        Class clazz = Person.class;
        System.out.println(clazz);
    }

    /**
     * 方式一
     */
    private static void forNameTest() {
        try {
            Class clazz = Class.forName("com.fang.reflect.Person");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

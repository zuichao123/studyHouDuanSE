package com.fang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的应用
 *
 * 常规情况下：
 *      先创建对象，再通过对象来调用方法，先有对象，再调方法。
 * 反射情况下：
 *      先获取方法对象，再调用方法对象的invoke()方法来完成目标方法的调用。
 *
 * 常规情况下，private的方法在外边无法访问，如果通过反射机制是可以在外边完成private方法的调用的，需要调用Method.setAccessible(true)来完成暴力访问。
 * 常规情况下，private的成员变量在外边无法访问，如果通过反射机制是可以在外边完成private方法的调用的，需要调用field.setAccessible(true)来完成暴力访问。
 * 常规情况下，private的构造函数在外边无法访问，但是在反射机制下，可以通过调用constructor.setAccessible(true)来完成暴力访问。
 *
 * 代理
 *      代理是反射的一个重要应用
 *      java中的代理模式的特点是委托类和代理类实现了同样的接口，即委托类和代理类都具备完成需求的能力，代理类可以为委托类进行消息预处理，过滤消息，以及事后处理消息等。
 *      代理类和委托类之间存在注入的关联关系，即在设计程序是需要将委托类定义为代理类的成员变量。
 *      代理类本身并不会真正的去执行业务逻辑，而是通过调用委托类的方式来完成。
 *
 *      简单来说就是我们在访问委托对象时，是通过代理对象来间接访问的，代理模式就是通过这种间接访问的方式，
 *      为程序预留出可处理的空间，利用此空间，在不影响核心业务的基础上可以附加其他的业务，这就是代理模式的好处。
 *
 *      静态代理
 *          静态代理需要预先写好代理类的代码，在编译期间代理类的class文件就已经生成。
 *
 *      动态代理
 *          指在编译期并没有确定具体的代理类，在程序运行期间根据java的指示动态生成的方式。
 */
public class ReflectAplay {
    public static void main(String[] args) {
        Person person = new Person();

        // 常规
        int id = person.getId();
        System.out.println(id);

        // 反射
        Class clazz = Person.class;
        try {
            Method method = clazz.getDeclaredMethod("getId", null);
            int id2 = (int) method.invoke(person, null);
            System.out.println(id2);

            // ----------------反射调用方法
            method = clazz.getDeclaredMethod("getName", null);
            // 反射不能访问私有方法，设置一下访问权限就可以访问了
            method.setAccessible(true);
            String str = (String) method.invoke(person, null);
            System.out.println(str);

            // ----------------反射调用成员变量
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(person, "张三");
            System.out.println(person);

            // ----------------反射调用构造函数
            // 无参构造
            Constructor<Person> constructor = clazz.getConstructor(null);
            Person person2 = constructor.newInstance(null);
            System.out.println(person2);

            // 有参构造
            Constructor<Person> constructor2 = clazz.getDeclaredConstructor(int.class, String.class);
            constructor2.setAccessible(true);
            Person person3 = constructor2.newInstance(123, "三张");
            System.out.println(person3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

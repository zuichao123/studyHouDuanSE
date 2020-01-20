package com.fang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Class类中常用的方法
 *
 * public native Booleanisinterface()                                   判断该类是否为接口
 * public native boolean isArray()                                      判断该类是否为数组
 * public Boolean isAnnotation()                                        判断该类是否为注解
 * public String getName()                                              获取该类的全类名
 * public ClassLoader getClassLoader()                                  获取类加载器
 * public native Class<? super T> getSuperclass()                       获取该类的直接父类
 * public Package getPackage()                                          获取该类的包
 * public String getPackageName()                                       获取该类的包名
 * public Class<?>[] getInterfaces()                                    获取该类的全部接口
 * public native intgetModiflers()                                      获取该类的访问权限修饰符
 * public Filed[] getFields()                                           获取该类的全部公有成员变量，包括继承自父类和自定义的
 * public Filed[] getDeclaredFields()                                   获取该类的自定义成员变量
 * public Filed[] getField(String name)                                 通过名称获取该类的公有成员变量，包括继承自父类和自定义的
 * public Filed[] getDeclaredFiled(String name)                         通过名称获取该类的自定义成员变量
 * public Method[] getMethods()                                         获取该类的全部共有方法，包括继承自父类和自定义的
 * public Method[] getDeclaredMethods()                                 获取该类的自定义方法
 * public Method getMethod(String name, Class<T> ...parameterTypes)     通过名称和参数信息获取该类的公有方法
 * public Method getDeclaredMethod(String name, Class<T> ...parameterTypes)     通过名称和参数信息获取该类的自定义方法
 * public Constructor<?>[] getConstructors()                            获取该类的公有构造函数
 * public Constructor<?>[] getDeclaredConstructors()                    获取该类的全部构造函数
 * public Constructor<T> getConstructor(Class<?> ...parameterTypes)             通过参数信息获取该类的公有构造函数
 * public Constructor<T> getDeclaredConstructor(Class<?> ...parameterTypes)     通过参数信息获取该类的构造函数
 */

public class ClassTest {
    public static void main(String[] args) {
//        getInterfaces();
//        getSuperClass();
//        getConstructor();
//        getMethods();
        getFields();
    }

    private static void getFields() {
        try {
            // 获取所有的公有成员变量
            Class clazz = Class.forName("com.fang.reflect.Person");
            Field[] fields = clazz.getFields();
            for(Field f:fields){
                System.out.println(f);
            }

            // 获取自定义成员变量
            Field field = clazz.getDeclaredField("name");
            System.out.println(field.getName());
            System.out.println(field.getModifiers()); // 访问修饰符
            String str = Modifier.toString(field.getModifiers());
            System.out.println(str);
            System.out.println(field.getType()); // 类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void getMethods() {
        try {
            Class clazz = Class.forName("com.fang.reflect.Person");
            // 获取所有的公有方法
            System.out.println("*************获取所有的公有方法******************");
            Method[] methods = clazz.getMethods();
            for(Method mo:methods){
                System.out.println(mo);
            }

            // 获取指定的方法
            System.out.println("*************获取指定的方法(公有/私有都可以)******************");
            Method method = clazz.getDeclaredMethod("getName", null);
            System.out.println(method);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getConstructor() {
        /**
         * 公有的用  getConstructor
         * 私有的用  getDeclaredConstructor
         */

        // 获取公有的构造函数
        System.out.println("*************获取公有的构造函数******************");
        Class clazz = Person.class;
        Constructor<Person>[] constructors = clazz.getConstructors();
        for(Constructor<Person> constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println("**************获取所有的构造函数*****************");
        // 获取所有的构造函数
        constructors = clazz.getDeclaredConstructors();
        for(Constructor<Person> constructor : constructors){
            System.out.println(constructor);
        }
        // 获取一个参数的构造函数
        System.out.println("*************获取一个参数的构造函数******************");
        try {
            Constructor<Person> constructor = clazz.getDeclaredConstructor(int.class);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("*************获取两个参数的构造函数******************");
        // 获取两个参数的构造函数
        try {
            Constructor<Person> constructor2 = clazz.getDeclaredConstructor(String.class, double.class);
            System.out.println(constructor2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getSuperClass() {
        // 获取父类
        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);
    }

    private static void getInterfaces() {
        // 获取接口
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class class1 : interfaces){
            System.out.println(class1);
        }
    }

}

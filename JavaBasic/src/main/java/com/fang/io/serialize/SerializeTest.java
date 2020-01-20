package com.fang.io.serialize;

import java.io.*;

/**
 * 序列化是指将内存中的对象输出到硬盘文件中进行保存；
 * 反序列化就是相反的操作，从文件中读取数据并还原成内存中的对象。
 *
 * 序列化和反序列化操作：
 *  1、让类实现序列化接口（java.io.Serializable）
 *  2、通过数据流完成对象到文件的读写
 *
 * 序列化
 */
public class SerializeTest {
    public static void main(String[] args) {
//        serializeTest();
        deserializationTest();
    }

    /**
     * 反序列化
     */
    private static void deserializationTest() {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream = new FileInputStream("c:/sj.txt");
            objectInputStream =  new ObjectInputStream(inputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.getId()+", "+student.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 序列化
     */
    private static void serializeTest() {
        // 1、创建对象
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        // 2、通过 "  数据流  " 将对象写入到硬盘的文件中
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream("c:/sj.txt");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

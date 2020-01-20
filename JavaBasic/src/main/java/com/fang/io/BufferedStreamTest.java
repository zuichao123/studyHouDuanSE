package com.fang.io;

import java.io.*;

/**
 * 缓冲流
 *
 * 文件 -- 读入缓冲区 -- 读入程序内存 -- 程序
 *
 * 提高读取效率，减少对磁盘的访问
 *
 * 不能直接读取文件，只能对已存在的数据流进行封装
 *
 * 字节缓冲流
 *      字节输入缓冲流 BufferedInputStream
 *          使用字节流作为基础管道的基础上，提供了一个缓冲区，在访问硬盘时缓冲区可以一次性存入多个字节，
 *          从缓冲区中将数据读入到字节流中，再到程序内存中。
 *
 *      字节输出缓冲流 BufferedOutputStream
 *          将字符串转成byte（str.getBytes()）保存到byte数组中，使用字节输出缓冲流将字符内容写入到文件中。
 *
 * 字符缓冲流
 *      字符输入缓冲流 BufferedReader
 *          多了个readLine()方法，可以直接读取一整行数据；
 *
 *      字符输出缓冲流 BufferedWriter
 */
public class BufferedStreamTest {
    public static void main(String[] args) {
//        bufferedInputStreamTest();
//        bufferedOutputStreamTest();

        bufferedReaderTest();
//        bufferedWriterTest();
    }

    private static void bufferedWriterTest() {
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter("c:/j.txt");
            bufferedWriter = new BufferedWriter(writer);
            String str = "处理字节流的抽象类\n" +
                    " *\n" +
                    " *          InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等.\n" +
                    " *          OutputStream是字节输出流的所有类的超类,一般我们使用它的子类,如FileOutputStream等.";
            bufferedWriter.write(str);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void bufferedOutputStreamTest() {
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = new FileOutputStream("c:/s.txt");
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            String str = "处理字节流的抽象类\n" +
                    " *\n" +
                    " *          InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等.\n" +
                    " *          OutputStream是字节输出流的所有类的超类,一般我们使用它的子类,如FileOutputStream等.";
            byte[] bytes = str.getBytes();
            bufferedOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void bufferedReaderTest() {
        // 可以使用转换流将字节输入流转成字符流；也可以直接使用字符流
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

//        Reader reader = null;

        try {
            inputStream = new FileInputStream("c:/a.txt");
            inputStreamReader = new InputStreamReader(inputStream);

//            reader = new FileReader("c:/a.txt");

            bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void bufferedInputStreamTest() {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream("c:/a.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);

            int tmp = 0;
            while ((tmp = bufferedInputStream.read()) != -1) {
                System.out.println(tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.sunjian.ios;

import java.io.*;

/**
 * InputStream、OutputStream
 *      处理字节流的抽象类
 *
 *          InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等.
 *          OutputStream是字节输出流的所有类的超类,一般我们使用它的子类,如FileOutputStream等.
 *
 * InputStreamReader OutputStreamWriter
 *      处理字符流的抽象类
 *
 *          InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
 *          OutputStreamWriter是字符流通向字节流的桥梁，它将字符流转换为字节流.
 *
 * BufferedReader BufferedWriter
 *
 *      BufferedReader
 *          由Reader类扩展而来，提供通用的缓冲方式文本读取，readLine读取一个文本行，
 *          从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。
 *
 *      BufferedWriter
 *          由Writer 类扩展而来，提供通用的缓冲方式文本写入，newLine使用平台自己的行分隔符，
 *          将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 *
 */
public class CopyFile {
    public static void main(String[] args) {
        File file = new File("C:/a.txt");
        File file2 = new File("C:/aa.txt");

        copyFile(file, file2);
    }

    private static void copyFile(File file, File file2) {
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            file.createNewFile();
//            bufr = new BufferedReader(new FileReader(io));
//            bufw = new BufferedWriter(new FileWriter(file2));
            bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));

            char [] b = new char[1024];
            String str="";
            while ((str = bufr.readLine()) != null){
                bufw.write(str + System.lineSeparator());
                bufw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufw!=null){
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufr!=null){
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

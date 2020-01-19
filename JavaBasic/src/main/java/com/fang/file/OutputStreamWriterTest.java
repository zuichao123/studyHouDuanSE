package com.fang.file;

import java.io.*;

/**
 * 输出处理流
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        Writer writer = null;

        try {
            outputStream = new FileOutputStream("c:/1a.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream);
            writer = outputStreamWriter;

            String str = "大法师打发斯蒂芬";
            char[] chars = str.toCharArray();
            writer.write(chars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                outputStreamWriter.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

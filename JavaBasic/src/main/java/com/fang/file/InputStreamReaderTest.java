package com.fang.file;

import java.io.*;

/**
 * 输入处理流
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        Reader reader = null;
        try {
            inputStream = new FileInputStream("c:/a.txt");
            inputStreamReader = new InputStreamReader(inputStream);
            reader = inputStreamReader;
            int tmp = 0;
            while ((tmp = reader.read()) != -1){
                System.out.println(tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

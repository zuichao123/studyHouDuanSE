package com.fang.network.tcp;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        try {
            // 建立客户端socket，连接端口为8888的本地服务
            socket = new Socket("10.2.1.96", 8888);

            // 给服务器发送消息
            String message = "服务器你好，我是客户端A";
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(message);

            // 接收服务器的响应
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String response = dataInputStream.readUTF();
            System.out.println("服务器说："+response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                inputStream.close();
                dataOutputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

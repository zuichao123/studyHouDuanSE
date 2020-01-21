package com.fang.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            // 建立ServerSocket监听，端口为8888
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器一启动，等待接收客户端请求...");

            // 等待客户端请求，并返回Socket对象
            socket = serverSocket.accept();
            // 接收客户端请求
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String request = dataInputStream.readUTF();
            System.out.println("客户端说："+request);

            // 给客户端做出响应
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            String response = "客户端你好，我是服务器";
            dataOutputStream.writeUTF(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
                outputStream.close();
                dataInputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

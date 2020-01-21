package com.fang.network.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7771);
            System.out.println("服务器已启动");
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new ServerRunnable(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerRunnable implements Runnable{
    private Socket socket;
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        try {
            inputStream = this.socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
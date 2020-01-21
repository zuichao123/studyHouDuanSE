package com.fang.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Receive {
    public static void main(String[] args) {
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 接收数据包
        byte[] buff = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
        DatagramSocket datagramSocket = null;
        try {
            // 接收8889端口的数据
            datagramSocket = new DatagramSocket(8889);
            datagramSocket.receive(datagramPacket);
            String mess = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(datagramPacket.getPort()+"传输的数据为："+mess);

            // 发送数据包
            String reply = "我已接收到你的信息";
            SocketAddress socketAddress = datagramPacket.getSocketAddress();
            DatagramPacket datagramPacket1 = new DatagramPacket(reply.getBytes(), reply.getBytes().length, socketAddress);
            datagramSocket.send(datagramPacket1);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}

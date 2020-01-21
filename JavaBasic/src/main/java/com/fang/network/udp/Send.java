package com.fang.network.udp;

import java.io.IOException;
import java.net.*;

public class Send {
    public static void main(String[] args) {
        String mess = "我是一个请求";
        DatagramSocket datagramSocket = null;

        // 数据打包--发送
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(mess.getBytes(), mess.getBytes().length, inetAddress,8889);
            datagramSocket = new DatagramSocket(8887);
            // 将mess通过8887端口，发送给本地的8889端口
            datagramSocket.send(datagramPacket);

            // 接收返回的数据包
            byte[] buff = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(buff, buff.length);
            datagramSocket.receive(datagramPacket1);
            String reply = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
            System.out.println(datagramPacket1.getPort()+"返回的信息为："+reply);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}

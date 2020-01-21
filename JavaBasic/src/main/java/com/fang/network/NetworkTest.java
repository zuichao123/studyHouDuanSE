package com.fang.network;

import java.io.*;
import java.net.*;

/**
 * 网络编程
 *      计算机网络就是通过硬件设施，传输媒介把分散在不同地区的计算机进行连接，形成了一个资源共享和数据传输的网络系统。
 *      两台终端通过网络进行连接时，需要遵守一定的规则，这个规则就是网络通信协议：
 *          tcp/ip协议
 *              分层的
 *              分为四层
 *                  应用层
 *                  传输层
 *                  网络层
 *                  数据链路层
 *
 *          IPX/SPX协议
 *          NetBEUI协议
 *
 *          IP地址：
*                  IP地址：网络地址+主机地址
*                  网络地址：用来识别主机所在的网络
*                  主机地址：用来识别网络中的主机
*                  IP地址分为5类：
*                      A类地址：政府机构使用       1.0.0.1 ~  126.255.255.254
*                      B类地址：大中型公司企业     128.0.0.1 ~ 191.255.255.254
*                      C类地址：个人使用           192.0.0.1 ~ 223.255.255.254
*                      D类地址：用于组播           224.0.0.1 ~ 239.255.255.254
*                      E类地址：用于实验           240.0.0.1 ~ 255.255.255.254
*
*                      127.0.0.1 表示本机；localhost也是表示本机
 *
 *                  java中有专门表示IP地址的类：java.net.InetAddress
 *                  常用方法：
 *                  public static InetAddress getLocalHost()                获取本机IP对应的InetAddress对象
 *                  public static InetAddress getByName(String host)        通过主机名称获取对应IP的InetAddress对象
 *                  String getHostAddress()                                 获取电脑的IP地址
 *                  String getHostName()                                    获取电脑的用户名
 *
 *          端口：
 *              如果把IP地址比作移动大厦的地址，那么端口就是不同的房间的门牌号，IP地址需要和端口结合起来使用，
 *              IP地址负责找到终端，一台终端可以同时运行多个服务，通过端口来确定具体的服务。
 *
 *          URL：
 *              URL统一资源定位符，可以直接通过URL找到互联网中资源，网页HTML、文字、图片、视频、音频。
 *              常用方法：
 *                  public URL(String protocol, String host, int port, String file)         通过协议IP地址端口号资源名称获取URL对象
 *                  public
 *
 *          URLConnection：
 *              封装访问远程网络资源一般方法的类，通过它可以建立与远程服务器的链接，检测远程资源的一些属性。
 *              常用方法：
 *                  public int getContentLength()           获取内容的长度，int类型
 *                  public long getContentLength()          获取资源的长度
 *                  String getContentType()                 获取内容的长度、类型
 *
 *          编码：
 *              对中文字符进行编码解码。
 *
 *          TCP & UDP：
 *              TCP
 *                  可靠的链接/三次握手/四次挥手
 *                  1、先建立连接，确定连接之后，再进行数据传输；
 *                  2、一方每传输一次数据，需要对方确认响应，再进行下一次数据传输，如果没有响应，就一直等待。
 *
 *              UDP
 *                  不可靠的连接、只管发送，不管对方是否能够收到。
 *
 *              TCP可靠，效率低；UDP虽然不可靠，但是效率高。
 *              需要根据具体的业务场景来决定选择TCP还是UDP（金融系统一定是TCP；语音通话、视频通话都是UDP）。
 *
 *          SOCKET：
 *              TCP协议的：
 *                  在socket程序开发中，服务端使用ServerSocket等待客户端的请求，对于Java网络来说，每一个客户端都使用一个Socket对象来表示。
 *
     *              ServerSocket类常用方法：服务端
     *                  public ServerSocket(int port)           通过端口创建ServerSocket实例对象
     *                  public InetAddress getInetAddress()     获取服务器的IP地址
     *                  public Socket accpet()                  等待客户端请求，并返回Socket对象
     *                  public void close()                     关闭ServerSocket对象
     *                  public boolean isClosed()               判断ServerSocket是否关闭
     *
     *              Socket类常用方法：客户端
     *                  public Socket(String port, int port)        根据服务器IP、端口，创建要连接的Socket对象
     *                  public InputStream getInputStream()         获取Socket的输入流
     *                  public synchronized void close()            关闭Socket
     *                  public boolean isClosed()                   判断Socket是否关闭
 *
 *              UDP协议的：
 *                  java中使用DataGramSocket类和DatagramPacket类完成UDP程序的开发。
 *                  DatagramSocket的常用方法：
 *                      public DatagramSocket(int port)                         根据端口创建DatagramSocket实例对象
 *                      public void send(DatagramPacket p)                      发送数据
 *                      public synchromized void recevie(DatagramPzcket p)      接收数据
 *
 *                  DatagramPacket的常用方法：
 *                      public DatagramPacket(byte buf[], int length, InetAddress address, int port)        根据发送的数据，数据长度、IP地址、端口号创建DatagramPacket对象
 *                      public synchronized byte[] getData()                    获取接收到的数据
 *                      public synchronized int getLength()                     获取数据的长度
 *                      public synchronized int getPort()                       获取发送数据的Socket端口
 *                      public synchronized SocketAddress getSocketAddress()    获取发送数据的Socket信息
 *
 *
 */

public class NetworkTest {
    public static void main(String[] args) {
//        ip();
//        url();
//        urlConnection();
        code();
    }

    private static void code() {
        String str = "张三";
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            System.out.println("编码："+encode);
            String decode = URLDecoder.decode(encode, "utf-8");
            System.out.println("解码："+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void urlConnection() {
        try {
            URL url = new URL("http", "10.2.1.35", 20080, "/index.html");
            URLConnection urlConnection = url.openConnection();
            long length = urlConnection.getContentLengthLong();
            System.out.println("资源的长度："+length);
            String type = urlConnection.getContentType();
            System.out.println("资源的类型："+type);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void url() {
        BufferedReader bufr = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        try {
            URL url = new URL("http", "10.2.1.35", 20080, "/index.html");
            inputStream = url.openStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufr = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufr.readLine()) != null){
                System.out.println(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufr.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void ip() {
        try {
            // 获取本机InetAddress
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress);

            // 获取主机名
            System.out.println(inetAddress.getHostName());
            // 获取IP地址
            System.out.println(inetAddress.getHostAddress());
            // 获取其他电脑的InetAddress
            InetAddress inetAddress1 = InetAddress.getByName("10.2.1.95");
            System.out.println(inetAddress1.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

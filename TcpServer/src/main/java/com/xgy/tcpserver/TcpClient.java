package com.xgy.tcpserver;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class TcpClient implements BaseClass{

    private Socket socket;
    private SocketAddress socketAddress;

    private String remoteTcpServerHostname = "127.0.0.1";
    private int port = 12345;

    @Override
    public boolean init() {
        try {
            socketAddress = new InetSocketAddress(remoteTcpServerHostname, port);
            socket        = new Socket();
//            socket = new Socket(remoteTcpServerHostname, port);
            socket.connect(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean start() {

        if (!socket.isConnected()) {
            System.out.println("socket is not connected");
        }

        if (!process()) {
            System.out.println("process failed");
            return false;
        }


        return true;
    }

    @Override
    public boolean uninit() {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean process() {

        System.out.println("已连接到服务器，" + socket.getRemoteSocketAddress());

        try {
            //读取服务器端数据
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //向服务器端发送数据
            PrintStream out = new PrintStream(socket.getOutputStream());
            System.out.print("请输入: \t");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            out.println(str);

            String ret = input.readLine();
            System.out.println("服务端: " + ret);
            if ("OK".equals(ret)) {
                System.out.println("客户端将关闭连接");
                Thread.sleep(500);
            }

            out.close();
            input.close();

        } catch (Exception e) {
            System.out.println("客户端异常:" + e.getMessage());
        } finally {
            if (socket != null && socket.isConnected() && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("客户端 finally 异常:" + e.getMessage());
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        TcpClient tcpClient = new TcpClient();

        if (!tcpClient.init()) {
            System.out.println("TcpClient init failed");
            return;
        }

        if (!tcpClient.start()) {
            System.out.println("TcpClient start failed");
            return;
        }

        if (!tcpClient.uninit()) {
            System.out.println("TcpClient uninit failed");
            return;
        }

    }

}

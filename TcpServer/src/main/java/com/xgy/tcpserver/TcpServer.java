package com.xgy.tcpserver;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class TcpServer implements BaseClass {

    private ServerSocket serverSocket;
    private SocketAddress socketAddress;

    private String hostname = "127.0.0.1";
    private int port = 12345;

    private boolean isRunning = false;

    private StatisticsThread statisticsThread = new StatisticsThread();

    private SessionManager sessionManager = new SessionManager();

    private TcpServer() {

    }

    private static TcpServer tcpServer = null;

    public static TcpServer getInstance() {
        if (null == tcpServer) {
            synchronized (TcpServer.class) {
                if (null == tcpServer) {
                    tcpServer = new TcpServer();
                }
            }
        }
        return tcpServer;
    }

    @Override
    public boolean init() {

        try {

            System.out.println("TcpServer init ......");
            socketAddress = new InetSocketAddress(hostname, port);
            serverSocket = new ServerSocket();
            serverSocket.bind(socketAddress);

            //启动统计线程
            statisticsThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean start() {
        isRunning = true;
        System.out.println("TcpServer start ......");
        while (isRunning) {
            try {
                Socket socket = serverSocket.accept();
                sessionManager.createSession(socket);
                WorkThread workThread = new WorkThread(socket);
                workThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean uninit() {

        try {
            if (!serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TcpServer uninit ......");

        return true;
    }

    public int getOnlineClientCount() {

        return sessionManager.getSessionCount();
    }

    public static void main(String[] args) {

//        TcpServer tcpServer = new TcpServer();
        TcpServer tcpServer = TcpServer.getInstance();

        if (!tcpServer.init()) {
            System.out.println("TcpServer init failed");
            return;
        }

        if (!tcpServer.start()) {
            System.out.println("TcpServer start failed");
            return;
        }

        if (!tcpServer.uninit()) {
            System.out.println("TcpServer uninit failed");
            return;
        }

    }

}

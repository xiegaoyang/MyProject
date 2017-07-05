package com.xgy.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class WorkThread extends Thread {

    private Socket socket;

    private BufferedReader input = null;
    private PrintStream out = null;

    private boolean isRunning = true;

    WorkThread(Socket socket) {

        this.socket = socket;

        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        System.out.println("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());

        while (socket.isConnected() && !socket.isClosed()) {
            if (!processRequest()) {
                System.out.println("processRequest failed, socket = " + socket);
                break;
            }
        }

        try {
            System.out.println("断开连接：" + socket.getInetAddress() + ":" + socket.getPort() + "\n");
            if (!socket.isClosed()) {
                socket.close();
                socket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean processRequest() {

        try {

            socket.sendUrgentData(0); //判断客户端是否断开连接    导致客户端重置连接，Connection reset，后面读取就会报错。

            String clientInputStr = input.readLine();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException   输入内容要换行
            if (null == clientInputStr) { //也可以判断客户端是否重置连接
                return false;
            }
            System.out.println("客户端:" + clientInputStr);
            write("welcome");

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private boolean write(String content) {
        // 向客户端回复信息
        try {
            out = new PrintStream(socket.getOutputStream());

            // 发送键盘输入的一行
//            System.out.print("请输入:\t");
//            String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

            out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }


}

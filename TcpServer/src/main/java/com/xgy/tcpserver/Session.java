package com.xgy.tcpserver;

import java.net.Socket;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class Session {

    private int id;
    private Socket socket;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

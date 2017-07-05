package com.xgy.tcpserver;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class StatisticsThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000 * 60 * 1);
                System.out.println(CommonService.getCurrentTime() + "  当前在线客户端数：" + TcpServer.getInstance().getOnlineClientCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

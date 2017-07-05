package com.xgy.tcpserver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class CommonService {

    private static Integer lastSessionId = 0;

    public static int generateSessionId() {
        synchronized (lastSessionId) {
            lastSessionId++;
        }
        return lastSessionId;
    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

}

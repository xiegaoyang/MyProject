package com.xgy.taskshedule;

import java.util.Date;
import java.util.TimerTask;

/**
 * 不可动态修改的任务
 *
 * @author arron
 * @date 2015年5月7日 下午1:52:15
 * @version 1.0
 */
public class FixedTimerTask extends TimerTask{

    @Override
    public void run() {
        Date d = new Date();
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(1000);
                System.out.println("已执行【"+(i+1)+"】秒钟，at: "+d.toLocaleString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("本次任务调度结束，at: "+new Date().toLocaleString());
        System.out.println("---------------------------");
    }

}

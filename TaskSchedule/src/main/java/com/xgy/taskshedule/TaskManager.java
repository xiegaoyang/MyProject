package com.xgy.taskshedule;

/**
 * Created by gowild.cn on 2017/6/12.
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 任务调度管理器
 *
 * @author arron
 * @date 2015年5月7日 下午1:57:19
 * @version 1.0
 */
public class TaskManager {
    //  private static final long PERIOD = 5 * 60 * 1000;// 5分钟
    private static final long PERIOD = 5 * 1000;// 1秒钟

    public TaskManager() {
        Timer timer = new Timer();
        FixedTimerTask task = new FixedTimerTask();
        System.out.println("start");


        //0表示立即执行一次，以后每隔一段时间执行一次
        timer.schedule(task, 0, PERIOD);//核心

        //1000表示1秒后执行一次，以后每隔一段时间执行一次
        //timer.schedule(task, 1000, PERIOD);

        //0表示立即执行一次，以后每隔一段时间执行一次
        //timer.schedule(task, 1000, PERIOD);

        // 在当天14点4分整，执行一次，以后不再执行
        //timer.schedule(task, bookTime(15,0,0));

        //在当天14点4分整，执行一次，以后每隔一段时间执行一次
        //如果时间超过了设定时间，会立即执行一次
//      timer.schedule(task, bookTime(0,34,10),PERIOD);
//      timer.scheduleAtFixedRate(task, bookTime(0,40,0),PERIOD);

    }


    private Date bookTime(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        Date date = calendar.getTime();
        return date;
    }

    public static void main(String[] args) {
        new TaskManager();
    }
}

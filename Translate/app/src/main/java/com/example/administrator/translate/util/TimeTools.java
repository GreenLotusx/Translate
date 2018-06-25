package com.example.administrator.translate.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/24.
 */

public class TimeTools {
    /**
     * 时间字符串
     *
     * @return
     */
    public static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String time = sdf.format(date);
        return time;

    }

    /**
     * 格式化时间
     */
    public static String getStandardTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String time = sdf.format(date);
        return time;

    }


    /**
     * 格式化时间,精确到毫秒
     */
    public static String getPrecisionStandardTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = new Date(System.currentTimeMillis());
        String time = sdf.format(date);
        return time;

    }


    /**
     * 获取当前的时间戳
     */
    public static long getTimestamp() {
        long millis = System.currentTimeMillis();
        return millis;
    }
}

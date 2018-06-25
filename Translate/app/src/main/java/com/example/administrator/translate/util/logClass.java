package com.example.administrator.translate.util;

import android.util.Log;

import com.example.administrator.translate.base.MyApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/23.
 */

public class logClass {
    private static final boolean debug = true;
    private static String TAG = "运行至此";

    public static void d(String string) {
        if (debug) {
            Log.d(TAG, createMessage(string));
        }
    }

    public static void i(String string) {
        if (debug) {
            Log.i(TAG, createMessage(string));
        }
    }

    /**
     * 获取有类名与方法名的logString
     * @return classname
     */
    private static String createMessage(String rawMessage) {
        /**
         * Throwable().getStackTrace()获取的是程序运行的堆栈信息，也就是程序运行到此处的流程，以及所有方法的信息
         * 这里0是代表createMessage方法信息，1是代表上一层方法的信息，这里我们
         * 取2是上两层方法的信息
         */
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String fullClassName = stackTraceElement.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        return className + "." + stackTraceElement.getMethodName() + "(): " + rawMessage;
    }
}

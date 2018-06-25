package com.example.administrator.translate.util;

/**
*Author:Administrator
*Role:操作过快判断，防止操作过快作出多余响应
*Time:2018/5/24 18:51
**/
public class OperationTooFastUtil {
    private static long lastClickTime;
    public static boolean ifOnTextChanged() {
        long time = System.currentTimeMillis();
        if ( time - lastClickTime < 100) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}

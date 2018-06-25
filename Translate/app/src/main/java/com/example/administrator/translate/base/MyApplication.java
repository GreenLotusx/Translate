package com.example.administrator.translate.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

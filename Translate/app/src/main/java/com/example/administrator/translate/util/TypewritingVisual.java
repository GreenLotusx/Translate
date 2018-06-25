package com.example.administrator.translate.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.administrator.translate.base.MyApplication;

/**
 * Created by Administrator on 2018/5/22.
 */

public class TypewritingVisual{
    private Context context;
    public TypewritingVisual(Context context){
        this.context = context;
    }
    /*
    显示输入法
     */
    public void toggleSoftInput(View view) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.requestFocus();
            imm.showSoftInput(view, 0);
        }
    }
    public void tooggleSoftInputHide(View view){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

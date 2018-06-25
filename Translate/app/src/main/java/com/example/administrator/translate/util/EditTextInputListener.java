package com.example.administrator.translate.util;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.administrator.translate.interFace.BaiduEncyclopediaInterFace;
import com.example.administrator.translate.interFace.YoudaoInterFace;
import com.example.administrator.translate.presenter.BaiduEncyclopediaPresenter;
import com.example.administrator.translate.presenter.YoudaoPresenter;


/**
 * EditText变化监听，如果发生变化且内容不为空则发送网络请求
 * Created by Administrator on 2018/5/21.
 */

public class EditTextInputListener implements TextWatcher {
    public String string = "";
    private EditText input;
    private int a = 0;
    private YoudaoInterFace.YoudaoView youdaoView;
    private BaiduEncyclopediaInterFace.BaiduEncyclopediaView baiduEncyclopediaView;
    private Long beforeTimestamp = 1L, afterTimestamp = 1L;
    private Long apartTimestamp = 1L;
    private Button clear_btn;
    private LinearLayout invisible_layout,btn_layout;

    public EditTextInputListener(EditText input, YoudaoInterFace.YoudaoView youdaoView, Button clear_btn, LinearLayout invisible_layout, BaiduEncyclopediaInterFace.BaiduEncyclopediaView baiduEncyclopediaView,LinearLayout btn_layout) {
        this.input = input;
        this.youdaoView = youdaoView;
        this.baiduEncyclopediaView = baiduEncyclopediaView;
        this.clear_btn = clear_btn;
        this.btn_layout = btn_layout;
        this.invisible_layout = invisible_layout;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//           new  YoudaoPresenter(view).youdaoLoadData(string);
        if (!input.getText().toString().equals("")){
            btn_layout.setVisibility(View.GONE);
            clear_btn.setVisibility(View.VISIBLE);
            invisible_layout.setVisibility(View.VISIBLE);
        }else {
            btn_layout.setVisibility(View.VISIBLE);
            clear_btn.setVisibility(View.GONE);
            invisible_layout.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        string=input.getText().toString();
        if (string.equals("")){
            a = 0;
        }else {
            a = a + 1;
        }
        if (a % 2 != 0) {
            if (beforeTimestamp == 1L) {
                beforeTimestamp = TimeTools.getTimestamp();
            } else {
                beforeTimestamp = afterTimestamp;
                afterTimestamp = TimeTools.getTimestamp();
            }
        } else {
            if (afterTimestamp == 1L){
            afterTimestamp = TimeTools.getTimestamp();}
            else {
                beforeTimestamp = afterTimestamp;
                afterTimestamp = TimeTools.getTimestamp();
            }
        }
        apartTimestamp = afterTimestamp-beforeTimestamp;
        logClass.d("before:" + beforeTimestamp);
        logClass.d("after:" + afterTimestamp);
        logClass.d("相距时间：" + (afterTimestamp - beforeTimestamp));
        if (apartTimestamp < 0){
            new  YoudaoPresenter(youdaoView).youdaoLoadData(string);
            new BaiduEncyclopediaPresenter(baiduEncyclopediaView).baiduEncyclopediaLoadData(string);
        }else if (apartTimestamp >= 200){
            new  YoudaoPresenter(youdaoView).youdaoLoadData(string);
            new BaiduEncyclopediaPresenter(baiduEncyclopediaView).baiduEncyclopediaLoadData(string);
        }else {
            logClass.d("执行到此");
            youdaoView.youdaoSetdata(null);
        }
    }
}

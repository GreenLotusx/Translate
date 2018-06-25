package com.example.administrator.translate.presenter;

import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.interFace.YoudaoInterFace;
import com.example.administrator.translate.model.YoudaoModel;
import com.example.administrator.translate.util.JsonParsingUtil;
import com.example.administrator.translate.util.logClass;

import org.json.JSONException;

/**
 * Created by Administrator on 2018/5/23.
 */

public class YoudaoPresenter implements YoudaoInterFace.YoudaoPresenter,CallBackDataInterFace{
    private YoudaoInterFace.YoudaoView view;
    private YoudaoInterFace.YoudaoModel model;
    public YoudaoPresenter(YoudaoInterFace.YoudaoView  view) {
        this.view = view;
        this.model = new YoudaoModel();
    }
    @Override
    public void youdaoLoadData(String input) {
        model.youdaoGetData(this,input);
    }

    @Override
    public void calback(String data) {
        view.youdaoSetdata(data);
    }
}

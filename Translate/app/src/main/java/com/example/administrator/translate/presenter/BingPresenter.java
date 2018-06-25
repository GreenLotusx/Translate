package com.example.administrator.translate.presenter;

import com.example.administrator.translate.interFace.BingInterFace;
import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.model.BingModel;
import com.example.administrator.translate.util.JsonParsingUtil;
import com.example.administrator.translate.util.logClass;

import org.json.JSONException;

/**
 * Created by Administrator on 2018/5/22.
 */

public class BingPresenter implements BingInterFace.BingPicPresenter ,CallBackDataInterFace {
    private BingInterFace.BingPicView view;
    private BingInterFace.BingPicModel model;
    public BingPresenter(BingInterFace.BingPicView view) {
        this.view = view;
        this.model = new BingModel();
    }

    @Override
    public void bingPicLoadData() {
        model.bingPicGetData(this);
    }

    @Override
    public void calback(String data) {
//        data = analysisData(data);
        view.bingPicSetdata(data);
    }
}

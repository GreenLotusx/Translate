package com.example.administrator.translate.presenter;

import android.util.Log;

import com.example.administrator.translate.interFace.BaiduEncyclopediaInterFace;
import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.model.BaiduEncyclopediaModel;

/**
 * Created by Administrator on 2018/5/27.
 */

public class BaiduEncyclopediaPresenter implements BaiduEncyclopediaInterFace.BaiduEncyclopediaPresenter,CallBackDataInterFace {
    private BaiduEncyclopediaInterFace.BaiduEncyclopediaView view;
    private BaiduEncyclopediaInterFace.BaiduEncyclopediaModel model;
    public BaiduEncyclopediaPresenter(BaiduEncyclopediaInterFace.BaiduEncyclopediaView view){
        this.view = view;
        this.model = new BaiduEncyclopediaModel();
    }
    @Override
    public void baiduEncyclopediaLoadData(String string) {
        model.baiduEncyclopediaGetData(this,string);
    }

    @Override
    public void calback(String data) {
        view.baiduEncyclopediaSetData(data);
    }
}

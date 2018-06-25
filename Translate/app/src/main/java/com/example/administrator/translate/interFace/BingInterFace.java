package com.example.administrator.translate.interFace;

/**
 * Created by Administrator on 2018/5/22.
 */

public interface BingInterFace {
    /*
    *为桥梁添加model
    */
    interface BingPicModel {
        void bingPicGetData(CallBackDataInterFace a);
    }

    /*
    *view实现类
    */
    interface BingPicView{
        void bingPicSetdata(String str);
    }

    /*
    *Presenter实现类
    */
    interface BingPicPresenter{
        void bingPicLoadData();
    }
}

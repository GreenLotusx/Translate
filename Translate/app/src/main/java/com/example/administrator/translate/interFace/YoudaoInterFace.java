package com.example.administrator.translate.interFace;

/**
 * Created by Administrator on 2018/5/23.
 */

public interface YoudaoInterFace {
    interface YoudaoModel {
        void youdaoGetData(CallBackDataInterFace a,String input);
    }
    interface YoudaoView{
        void youdaoSetdata(String str);
    }
    interface YoudaoPresenter{
        void youdaoLoadData(String string);
    }
}

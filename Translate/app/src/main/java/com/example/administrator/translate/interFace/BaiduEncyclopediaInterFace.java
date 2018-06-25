package com.example.administrator.translate.interFace;

/**
 * Created by Administrator on 2018/5/27.
 */

public interface BaiduEncyclopediaInterFace {
    interface BaiduEncyclopediaModel {
        void baiduEncyclopediaGetData(CallBackDataInterFace a,String input);
        void baiduEncyclopediaDataAnalysis(CallBackDataInterFace callBackDataInterFace,String responseData);
    }

    interface BaiduEncyclopediaView {
        void baiduEncyclopediaSetData(String str);
    }

    interface BaiduEncyclopediaPresenter {
        void baiduEncyclopediaLoadData(String string);
    }
}

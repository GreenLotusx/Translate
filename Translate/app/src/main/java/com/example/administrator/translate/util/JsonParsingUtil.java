package com.example.administrator.translate.util;


import android.util.Log;

import com.example.administrator.translate.bean.BaiduEncyclopedia;
import com.example.administrator.translate.bean.Bing;
import com.example.administrator.translate.bean.Youdao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by Administrator on 2018/5/21.
 */


public class JsonParsingUtil {
    private final String TAG = "运行至此";
    private String returnStr;
    private List<String> returnList;

    public String jsonParsing(String jsonData, String call) throws JSONException {
        Gson gson = new Gson();
        JSONObject jsonobject = new JSONObject(jsonData);
        if (call.equals("bing")) {
            JSONObject jsonarray = jsonobject.getJSONObject("data");
            java.lang.reflect.Type type = new TypeToken<Bing.DataBean>() {
            }.getType();
            Bing.DataBean b = gson.fromJson(jsonarray.toString(), type);
            Log.d(TAG, "jsonParsing: " + b.getUrl());
            returnStr = b.getUrl();
        } else if (call.equals("youdao")) {
            JSONObject jsonarray = jsonobject.getJSONObject("data");
            java.lang.reflect.Type type = new TypeToken<Youdao.DataBean>() {
            }.getType();
            Youdao.DataBean b = gson.fromJson(jsonarray.toString(), type);
            returnStr = b.getTranslation();
        }else if (call.equals("baidu_encyclopedia")){
            JSONObject jsonarray = jsonobject.getJSONObject("data");
            java.lang.reflect.Type type = new TypeToken<BaiduEncyclopedia.DataBean>() {
            }.getType();
            BaiduEncyclopedia.DataBean b = gson.fromJson(jsonarray.toString(), type);
            returnStr = b.getContent();
        }
        return returnStr;
    }
}

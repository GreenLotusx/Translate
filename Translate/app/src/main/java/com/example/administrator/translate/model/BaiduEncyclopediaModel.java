package com.example.administrator.translate.model;

import android.util.Log;

import com.example.administrator.translate.interFace.BaiduEncyclopediaInterFace;
import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.util.HttpUtil;
import com.example.administrator.translate.util.JsonParsingUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/27.
 */

public class BaiduEncyclopediaModel implements BaiduEncyclopediaInterFace.BaiduEncyclopediaModel{
    private String ouput = null;
    @Override
    public void baiduEncyclopediaGetData(final CallBackDataInterFace callbackData, final String input) {
        Map<String, String> map = new HashMap<>();
        map.put("entry", input);

        HttpUtil.sendPostHttpRequest("http://47.106.146.250/baidu_encyclopedias",map, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                baiduEncyclopediaDataAnalysis(callbackData, responseData);
            }
        });
    }
    @Override
    public void baiduEncyclopediaDataAnalysis(CallBackDataInterFace callbackData, String responseData){
        try {
            JsonParsingUtil jsonparsingutil = new JsonParsingUtil();
            ouput = jsonparsingutil.jsonParsing(responseData, "baidu_encyclopedia");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (ouput != null) {
            callbackData.calback(ouput);
        }
    }
}

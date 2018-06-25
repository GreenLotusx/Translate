package com.example.administrator.translate.model;

import android.util.Log;

import com.example.administrator.translate.interFace.BingInterFace;
import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.util.HttpUtil;
import com.example.administrator.translate.util.JsonParsingUtil;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/22.
 */

public class BingModel implements BingInterFace.BingPicModel{

    private String responseData;
    private static final String TAG = "TEXT_LOG";
    public String url;
    @Override
    public void bingPicGetData(final CallBackDataInterFace callbackData) {
        HttpUtil.sendGetHttpRequest("http://47.106.146.250/getpicture", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseData = e.toString();
                Log.d(TAG, "onFailure: " + e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    responseData = response.body().string();
                    Log.d(TAG, "onResponse: "+responseData);
                    bingPicDataAnalysis(callbackData,responseData);
                }
            }
        });
    }
    public void bingPicDataAnalysis(CallBackDataInterFace callbackData,String responseData){
        try {
            JsonParsingUtil jsonparsingutil = new JsonParsingUtil();
            url = jsonparsingutil.jsonParsing(responseData, "bing");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "bingPicDataAnalysis: "+url);
        callbackData.calback(url);
    }
}

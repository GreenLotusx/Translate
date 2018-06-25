package com.example.administrator.translate.model;

import android.util.Log;

import com.example.administrator.translate.interFace.CallBackDataInterFace;
import com.example.administrator.translate.interFace.YoudaoInterFace;
import com.example.administrator.translate.util.HttpUtil;
import com.example.administrator.translate.util.JsonParsingUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/23.
 */

public class YoudaoModel implements YoudaoInterFace.YoudaoModel {
    private String ouput = null;

    @Override
    public void youdaoGetData(final CallBackDataInterFace callbackData, final String input) {
        Map<String, String> map = new HashMap<>();
        map.put("keyword", input);
        HttpUtil.sendPostHttpRequest("http://47.106.146.250/youdao", map, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("", "onFailure: 此处" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                youdaoDataAnalysis(callbackData, responseData, input);
            }
        });
    }

    public void youdaoDataAnalysis(CallBackDataInterFace callbackData, String responseData, String string) {
        if (!string.equals("")) {
            try {
                JsonParsingUtil jsonparsingutil = new JsonParsingUtil();
                ouput = jsonparsingutil.jsonParsing(responseData, "youdao");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            ouput = "";
        }
        if (ouput != null) {
            callbackData.calback(ouput);
        }
    }
}

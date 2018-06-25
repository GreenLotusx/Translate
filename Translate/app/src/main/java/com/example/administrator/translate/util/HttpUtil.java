package com.example.administrator.translate.util;


import java.util.Map;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by Administrator on 2018/5/20.
 * */

public class HttpUtil {
    public static void sendGetHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void sendPostHttpRequest(String address, Map<String,String> map,okhttp3.Callback callback){
        String keys = "",value = "";
        for (String key:map.keySet()){
            keys = key;
            value = map.get(key);
        }
        RequestBody body = new FormBody.Builder()
                .add(keys,value)
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}

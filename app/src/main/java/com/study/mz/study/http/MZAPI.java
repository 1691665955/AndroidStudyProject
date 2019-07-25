package com.study.mz.study.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MZAPI {
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static void request(String shortUrl, Map<String, Object> params, final MZAPICallback callback) {
        final String url = MZBaseInfo.getBaseUrl()+shortUrl;
        if (params == null) {
            params = new HashMap<>();
        }
        final Map<String, Object> logParams = new HashMap<>();
        logParams.putAll(params);

        final Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, gson.toJson(params));
        MZHttpRequest.sendRequestForPost(url, requestBody, new MZHttpCallback() {
            @Override
            public void onRequestFailure(IOException e) {
                e.printStackTrace();
                callback.onResponse(null,"网络错误");
            }

            @Override
            public void onRequestSuccess(Response response) {
                Log.d("MZAPI-Url",url);
                Log.d("MZAPI-Params",logParams.toString());
                String data = "";
                try {
                    data = response.body().string();
                    Log.d("MZAPI-data",data);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    final MZCommonJson json = gson.fromJson(data, MZCommonJson.class);
                    if (json.getCode() == 200) {
                        callback.onResponse(json,"ok");
                    } else {
                        callback.onResponse(null,json.getMsg());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onResponse(null,"网络错误");
                }
            }
        });
    }

    public static void novelApi(final MZAPICallback callback) {
        request("novelApi",null,callback);
    }

}

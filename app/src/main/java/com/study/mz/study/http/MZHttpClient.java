package com.study.mz.study.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MZHttpClient {
    private static class MZHttpClientInstance {
        public static final MZHttpClient instance = new MZHttpClient();
    }

    public OkHttpClient mOKHttpClient;
    public OkHttpClient getmOKHttpClient() {
        return mOKHttpClient;
    }
    private MZHttpClient() {
        mOKHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .build();
    }

    public static MZHttpClient shareInstance() {
        return MZHttpClientInstance.instance;
    }
}

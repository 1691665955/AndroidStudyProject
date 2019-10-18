package com.study.mz.study.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MZHttpRequest {
    private static Handler mainHandler = new Handler();

    public static void sendRequestForGet(final String url, final MZHttpCallback callback) {
        OkHttpClient okHttpClient = MZHttpClient.shareInstance().getmOKHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onRequestFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onRequestSuccess(response);
                    }
                });
            }
        });
    }

    public static void sendRequestForPost(final String url, final RequestBody requestBody, final MZHttpCallback callback) {
        OkHttpClient okHttpClient = MZHttpClient.shareInstance().getmOKHttpClient();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onRequestFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d("Thread", Thread.currentThread().getName());
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onRequestSuccess(response);
                    }
                });
            }
        });
    }
}

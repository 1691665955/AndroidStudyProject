package com.study.mz.study.http;

import java.io.IOException;

import okhttp3.Response;

public interface MZHttpCallback {
    public void onRequestFailure(IOException e);
    public void onRequestSuccess(Response response);
}

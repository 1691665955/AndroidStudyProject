package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.study.mz.study.http.MZAPI;
import com.study.mz.study.http.MZAPICallback;
import com.study.mz.study.http.MZCommonJson;
import com.study.mz.study.http.MZHttpCallback;
import com.study.mz.study.http.MZHttpRequest;
import com.study.mz.study.http.MZNovalBean;
import com.study.mz.study.util.ToastUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Response;
import okhttp3.ResponseBody;


public class HttpTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGet,mBtnPost;
    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_test);

        mBtnGet = findViewById(R.id.btn_get);
        mBtnPost = findViewById(R.id.btn_post);
        mTvContent = findViewById(R.id.tv_content);

        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                //get请求
                MZHttpRequest.sendRequestForGet("https://www.apiopen.top/meituApi?page=1", new MZHttpCallback() {
                    @Override
                    public void onRequestFailure(IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onRequestSuccess(Response response) {
                        try {
                            String string = response.body().string();
                            mTvContent.setText(string);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                break;
            case R.id.btn_post:
                //post请求
                MZAPI.novelApi(new MZAPICallback() {
                    @Override
                    public void onResponse(MZCommonJson data, String msg) {
                        if (msg.equals("ok")) {
                            List<Map> list = (List<Map>) data.getData();
                            List<MZNovalBean> novalBeans = MZNovalBean.parseBeanList(list);
                            MZNovalBean novalBean = novalBeans.get(1);
                            mTvContent.setText(novalBean.getBookname());
                        } else {
                            ToastUtil.showMsg(HttpTestActivity.this,msg);
                        }
                    }
                });
                break;

        }
    }
}

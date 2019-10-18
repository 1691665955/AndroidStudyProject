package com.study.mz.study;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.mz.study.http.MZAPI;
import com.study.mz.study.http.MZAPICallback;
import com.study.mz.study.http.MZCommonJson;
import com.study.mz.study.http.MZHttpCallback;
import com.study.mz.study.http.MZHttpRequest;
import com.study.mz.study.http.MZNovalBean;
import com.study.mz.study.http.MZSatinBean;
import com.study.mz.study.util.ToastUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Response;


public class HttpTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGet, mBtnPost;
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
                MZAPI.satinApi(1, 1, new MZAPICallback() {
                    @Override
                    public void onResponse(MZCommonJson data, String msg) {
                       if (msg.equals("ok")) {
                            List<Map> list = (List<Map>) data.getData();
                            List<MZSatinBean> satinBeans = MZSatinBean.parseBeanList(list);
                            MZSatinBean satinBean = satinBeans.get(1);
                            mTvContent.setText(satinBean.getText());
                        } else {
                            ToastUtil.showMsg(HttpTestActivity.this, msg);
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
                            ToastUtil.showMsg(HttpTestActivity.this, msg);
                        }
                    }
                });
                break;
        }
    }
}

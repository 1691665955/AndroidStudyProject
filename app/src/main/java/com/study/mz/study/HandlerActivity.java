package com.study.mz.study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.util.ToastUtil;

public class HandlerActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("Handler");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(HandlerActivity.this,getResources().getColor(R.color.colorPrimary),0);

//        mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"线程通讯成功");
                        break;
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }.start();

    }
}

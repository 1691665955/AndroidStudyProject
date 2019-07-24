package com.study.mz.study.boardcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.R;

public class BoardcastActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSend;
    private IntentFilter intentFilter;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardcast);

        mBtnSend = findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.study.mz.study.BroadcastTest");
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                Intent intent = new Intent("com.study.mz.study.BroadcastTest");
                sendBroadcast(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}

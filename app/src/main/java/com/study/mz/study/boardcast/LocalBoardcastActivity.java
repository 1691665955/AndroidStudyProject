package com.study.mz.study.boardcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.study.mz.study.R;

public class LocalBoardcastActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSend;
    private IntentFilter intentFilter;
    private MyReceiver myReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_boardcast);

        mBtnSend = findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.study.mz.study.BroadcastTest");
        myReceiver = new MyReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                Log.d("MyReceiver", "onReceive: 收到通知");
            }
        };
        localBroadcastManager.registerReceiver(myReceiver,intentFilter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                Intent intent = new Intent("com.study.mz.study.BroadcastTest");
                localBroadcastManager.sendBroadcast(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myReceiver);
    }
}

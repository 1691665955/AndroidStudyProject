package com.study.mz.study;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;
import com.study.mz.study.datastorage.DataStoregeActivity;
import com.study.mz.study.fragment.ContainerActivity;

public class MainActivity extends MZBaseActivity {

    private Button mBtnUI,mBtnFragment,mBtnEvent,mBtnHandler,mBtnData,mBtnBoardcast,mBtnHttp;
    private MZActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("主页");

        mActionBar = findViewById(R.id.action_bar);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBoardcast = findViewById(R.id.btn_boardcast);
        mBtnHttp = findViewById(R.id.btn_http);
        setListener();

        mActionBar.setStyle("首页");
//        mActionBar.setBackViewIcon(R.drawable.back,null);
        mActionBar.hiddenBackView(true);
        StatusBarUtil.setColor(MainActivity.this,getResources().getColor(R.color.colorPrimary),0);

        //获取读写权限
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBoardcast.setOnClickListener(onClick);
        mBtnHttp.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_handler:
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStoregeActivity.class);
                    break;
                case R.id.btn_boardcast:
                    intent = new Intent(MainActivity.this, LocalBoardcastActivity.class);
                    break;
                case R.id.btn_http:
                    intent = new Intent(MainActivity.this, HttpTestActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.datastorage.DataStoregeActivity;
import com.study.mz.study.fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnFragment,mBtnEvent,mBtnHandler,mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("主页");

        mBtnUI = findViewById(R.id.btn_ui);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnData = findViewById(R.id.btn_data);
        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
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
            }
            startActivity(intent);
        }
    }
}

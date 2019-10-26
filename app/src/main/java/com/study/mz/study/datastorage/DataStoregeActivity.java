package com.study.mz.study.datastorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;

public class DataStoregeActivity extends MZBaseActivity implements View.OnClickListener {

    private MZActionBar mActionBar;
    private Button mBtnSharePreferences,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storege);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("数据存储");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(DataStoregeActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mBtnSharePreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnSharePreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_sharedpreferences:
                intent = new Intent(this,SharePreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(this,FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}

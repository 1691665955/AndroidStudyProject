package com.study.mz.study.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.R;

public class DataStoregeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharePreferences,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storege);
        mBtnSharePreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnSharePreferences.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_sharedpreferences:
                intent = new Intent(this,SharePreferencesActivity.class);
                break;
        }
        startActivity(intent);
    }
}

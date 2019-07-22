package com.study.mz.study.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.study.mz.study.R;

public class SharePreferencesActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvShow;
    private SharedPreferences mSharePreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvShow = findViewById(R.id.tv_show);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

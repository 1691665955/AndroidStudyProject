package com.study.mz.study.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;

public class SharePreferencesActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvShow;
    private SharedPreferences mSharePreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("SharePreferences");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(SharePreferencesActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvShow = findViewById(R.id.tv_show);

        mSharePreferences = getSharedPreferences("data",MODE_PRIVATE);
        mEditor = mSharePreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putString("name",mEtName.getText().toString());
                mEditor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvShow.setText(mSharePreferences.getString("name",""));
            }
        });
    }
}

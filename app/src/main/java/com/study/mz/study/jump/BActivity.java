package com.study.mz.study.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.study.mz.study.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        this.setTitle("B");

        Bundle bundle = getIntent().getExtras();
        mTvTitle = findViewById(R.id.tv_title);
        if (bundle != null) {
            mTvTitle.setText(bundle.getString("name")+'+'+bundle.getString("id"));
        }

        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title","I'm back");
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}

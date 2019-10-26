package com.study.mz.study.jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class BActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private TextView mTvTitle;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        this.setTitle("B");

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("Jump");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(BActivity.this,getResources().getColor(R.color.colorPrimary),0);

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

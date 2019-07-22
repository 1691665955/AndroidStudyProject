package com.study.mz.study.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.study.mz.study.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private TextView mTvTitle;
    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mTvTitle = findViewById(R.id.tv_title);

        //实例化AFragment
        aFragment = AFragment.newInstance("我是AFragment");
        //把AFragment添加到Activity中,记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }

    //不推荐这种方法传递数据
    public void setData(String value) {
        mTvTitle.setText(value);
    }

    //推荐接口传值
    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}

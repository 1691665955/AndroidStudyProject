package com.study.mz.study.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.UIActivity;

public class ContainerActivity extends MZBaseActivity implements AFragment.IOnMessageClick {

    private MZActionBar mzActionBar;
    private TextView mTvTitle;
    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mzActionBar = findViewById(R.id.action_bar);
        mzActionBar.setStyle("FragmentFragmentFragmentFragmentFragment");
        mzActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(ContainerActivity.this,getResources().getColor(R.color.colorPrimary),0);

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

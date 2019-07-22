package com.study.mz.study;

import android.app.Activity;
import android.view.View;

import com.study.mz.study.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {
    private Activity mActivity;

    public MyClickListener(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(mActivity,"click...");
    }
}

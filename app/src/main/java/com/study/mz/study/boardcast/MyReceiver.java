package com.study.mz.study.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.study.mz.study.util.ToastUtil;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.study.mz.study.BroadcastTest")) {
            ToastUtil.showMsg(context,"收到自定义广播");
        } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            ToastUtil.showMsg(context,"手机网络状态变化");
        }
    }
}

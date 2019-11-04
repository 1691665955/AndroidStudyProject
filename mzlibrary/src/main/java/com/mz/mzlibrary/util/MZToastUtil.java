package com.mz.mzlibrary.util;

import android.content.Context;
import android.widget.Toast;

public class MZToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}

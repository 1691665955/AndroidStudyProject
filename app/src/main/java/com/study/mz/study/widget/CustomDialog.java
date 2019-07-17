package com.study.mz.study.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.study.mz.study.R;

public class CustomDialog extends Dialog implements View.OnClickListener{
    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;
    private String title;
    private String message;
    private String cancel;
    private String confirm;
    private IOnCancelListener cancelListener;
    private IOnConfrimListener confrimListener;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeId) {
        super(context,themeId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfrimListener listener) {
        this.confirm = confirm;
        this.confrimListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度
        WindowManager wm = getWindow().getWindowManager();
        Display display = wm.getDefaultDisplay();
        WindowManager.LayoutParams param = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        param.width = (int)(size.x * 0.8);//屏幕宽度80%
        getWindow().setAttributes(param);


        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);

        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }

        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if (confrimListener != null) {
                    confrimListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfrimListener {
        void onConfirm(CustomDialog dialog);
    }
}

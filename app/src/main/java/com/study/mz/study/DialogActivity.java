package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.util.ToastUtil;
import com.study.mz.study.widget.CustomDialog;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = new CustomDialog(DialogActivity.this,R.style.CustomDialog);
                dialog.setTitle("提示").setMessage("确认删除此项？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(DialogActivity.this,"取消");
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfrimListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(DialogActivity.this,"确认");
                    }
                }).show();
            }
        });
    }
}

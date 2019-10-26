package com.study.mz.study;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;
import com.study.mz.study.util.ToastUtil;

public class AlertDialogActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("AlertDialog");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(AlertDialogActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mBtnDialog1 = findViewById(R.id.btn_dialog_1);
        mBtnDialog2 = findViewById(R.id.btn_dialog_2);
        mBtnDialog3 = findViewById(R.id.btn_dialog_3);
        mBtnDialog4 = findViewById(R.id.btn_dialog_4);
        mBtnDialog5 = findViewById(R.id.btn_dialog_5);

        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_dialog_1:
                    final AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder1.setTitle("请回答").setMessage("你觉得课程如何？").setIcon(R.drawable.user).setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"棒");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"还行");
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"不好");
                        }
                    }).show();

                    break;
                case R.id.btn_dialog_2:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array2[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array3[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog_4:
                    final String[] array4 = new String[]{"唱歌","跳舞","写代码"};
                    final boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array4[i]+":"+b);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog_5:
                    final View dialogView =  LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText etUsername = dialogView.findViewById(R.id.et_username);
                    EditText etPassword = dialogView.findViewById(R.id.et_password);
                    Button mBtnLogin = dialogView.findViewById(R.id.btn_login);
                    final AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder5.setTitle("请先登录").setView(dialogView).setCancelable(false);
                    final AlertDialog dialog = builder5.create();
                    dialog.show();
                    mBtnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    break;
            }
        }
    }
}

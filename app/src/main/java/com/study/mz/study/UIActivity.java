package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.gridview.GridViewActivity;
import com.study.mz.study.jump.AActivity;
import com.study.mz.study.listview.ListViewActivity;
import com.study.mz.study.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnAlertDialog;
    private Button mBtnProgress;
    private Button mBtnDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        mBtnTextView = findViewById(R.id.btn_TextView);
        mBtnButton = findViewById(R.id.btn_Button);
        mBtnEditText = findViewById(R.id.btn_btn_EditText);
        mBtnRadioButton = findViewById(R.id.btn_RadioButton);
        mBtnCheckBox = findViewById(R.id.btn_CheckBox);
        mBtnImageView = findViewById(R.id.btn_ImageView);
        mBtnListView = findViewById(R.id.btn_ListView);
        mBtnGridView = findViewById(R.id.btn_GridView);
        mBtnRecyclerView = findViewById(R.id.btn_RecyclerView);
        mBtnWebView = findViewById(R.id.btn_WebView);
        mBtnToast = findViewById(R.id.btn_Toast);
        mBtnAlertDialog = findViewById(R.id.btn_AlertDialog);
        mBtnProgress = findViewById(R.id.btn_Progress);
        mBtnDialog = findViewById(R.id.btn_Dialog);
        mBtnPopupWindow = findViewById(R.id.btn_PopupWindow);
        mBtnLifeCycle = findViewById(R.id.btn_LifeCycle);
        mBtnJump = findViewById(R.id.btn_Jump);
        setListeners();
    }

    private void setListeners() {
        OnClick onclick = new OnClick();
        mBtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnEditText.setOnClickListener(onclick);
        mBtnRadioButton.setOnClickListener(onclick);
        mBtnCheckBox.setOnClickListener(onclick);
        mBtnImageView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnGridView.setOnClickListener(onclick);
        mBtnRecyclerView.setOnClickListener(onclick);
        mBtnWebView.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnAlertDialog.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnDialog.setOnClickListener(onclick);
        mBtnPopupWindow.setOnClickListener(onclick);
        mBtnLifeCycle.setOnClickListener(onclick);
        mBtnJump.setOnClickListener(onclick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_TextView:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_Button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_btn_EditText:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_RadioButton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_CheckBox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_ImageView:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_ListView:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_GridView:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_RecyclerView:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_WebView:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_Toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_AlertDialog:
                    intent = new Intent(UIActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.btn_Progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_Dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_PopupWindow:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_LifeCycle:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_Jump:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

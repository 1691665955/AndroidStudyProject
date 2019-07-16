package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.study.mz.study.gridview.GridViewActivity;
import com.study.mz.study.listview.ListViewActivity;
import com.study.mz.study.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

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
    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activcty_main);

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
        mBtnDialog = findViewById(R.id.btn_AlertDialog);
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
        mBtnDialog.setOnClickListener(onclick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_TextView:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_Button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_btn_EditText:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_RadioButton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_CheckBox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_ImageView:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_ListView:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_GridView:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_RecyclerView:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_WebView:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_Toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_AlertDialog:
                    intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

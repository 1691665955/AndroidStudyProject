package com.study.mz.study;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class EditTextActivity extends MZBaseActivity {
    private MZActionBar mActionBar;
    private Button mBtnLogin;
    private EditText mEtUserName;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("EditText");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(EditTextActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mBtnLogin = findViewById(R.id.login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });

        mEtUserName = findViewById(R.id.et_username);
        mEtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("editText",charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

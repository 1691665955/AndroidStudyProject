package com.study.mz.study;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class CheckBoxActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private CheckBox mCheckBoxCode,mCheckBoxCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("CheckBox");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(CheckBoxActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mCheckBoxCode = findViewById(R.id.cb_code);
        mCheckBoxCook = findViewById(R.id.cb_cook);

        mCheckBoxCode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this, b?"编程选择":"编程未选中", Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxCook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this, b?"煮饭选择":"煮饭未选中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

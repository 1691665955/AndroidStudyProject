package com.study.mz.study;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class RadioButtonActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private RadioGroup mRg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("RadioButton");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(RadioButtonActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mRg1 = findViewById(R.id.rg_1);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

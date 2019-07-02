package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCheckBoxCode,mCheckBoxCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

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

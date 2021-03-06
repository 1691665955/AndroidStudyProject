package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.widget.MZActionBar;

public class ButtonActivity extends AppCompatActivity {

    private MZActionBar mActionBar;
    private Button mButtonBtn3;
    private TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("Button");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(ButtonActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mButtonBtn3 = findViewById(R.id.btn_3);
        mButtonBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "btn3被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        mTextView1 = findViewById(R.id.tv_1);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "文字1被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "btn4被点击了", Toast.LENGTH_SHORT).show();
    }
}

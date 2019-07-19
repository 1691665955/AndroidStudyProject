package com.study.mz.study.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.mz.study.R;
import com.study.mz.study.util.ToastUtil;

public class AActivity extends AppCompatActivity {
    private Button mBtnJump1,mBtnJump2,mBtnJump3,mBtnJump4,mBtnJump5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        this.setTitle("A");

        mBtnJump1 = findViewById(R.id.btn_jump1);
        mBtnJump2 = findViewById(R.id.btn_jump2);
        mBtnJump3 = findViewById(R.id.btn_jump3);
        mBtnJump4 = findViewById(R.id.btn_jump4);
        mBtnJump5 = findViewById(R.id.btn_jump5);

        OnClick onClick = new OnClick();
        mBtnJump1.setOnClickListener(onClick);
        mBtnJump2.setOnClickListener(onClick);
        mBtnJump3.setOnClickListener(onClick);
        mBtnJump4.setOnClickListener(onClick);
        mBtnJump5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_jump1:
                    //显示跳转1
                    Intent intent1 = new Intent(AActivity.this,BActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","Tina");
                    bundle.putString("id","58");
                    intent1.putExtras(bundle);
//                    startActivity(intent1);
                    startActivityForResult(intent1,0);
                    break;
                case R.id.btn_jump2:
                    //显示跳转2
                    Intent intent2 = new Intent();
                    intent2.setClass(AActivity.this,BActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.btn_jump3:
                    //显示跳转3
                    Intent intent3 = new Intent();
                    intent3.setClassName(AActivity.this,"com.study.mz.study.jump.BActivity");
                    startActivity(intent3);
                    break;
                case R.id.btn_jump4:
                    //显式跳转4
                    Intent intent4 = new Intent();
                    intent4.setComponent(new ComponentName(AActivity.this,"com.study.mz.study.jump.BActivity"));
                    startActivity(intent4);
                    break;
                case R.id.btn_jump5:
                    //隐式跳转1
                    Intent intent5 = new Intent();
                    intent5.setAction("android.intent.action.test.BActivity");
                    startActivity(intent5);
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            ToastUtil.showMsg(AActivity.this,data.getExtras().getString("title"));
        }
    }
}

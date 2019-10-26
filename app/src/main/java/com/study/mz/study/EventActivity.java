package com.study.mz.study;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.util.ToastUtil;

public class EventActivity extends MZBaseActivity implements View.OnClickListener {

    private MZActionBar mActionBar;
    private Button mBtnEvent, mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("Event");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(EventActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mBtnEvent = findViewById(R.id.btn_event);
        //内部类
        mBtnEvent.setOnClickListener(new OnClick());
//        //匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showMsg(EventActivity.this,"click...");
//            }
//        });
//        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
//        //通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        mBtnMy = findViewById(R.id.btn_my);
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---OnTouchListener---");
                        break;
                }
                return false;
            }
        });
        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Listener", "---OnClickListener---");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "click...");
                break;
        }
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this, "click...");
                    break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "---onTouchEvent---");
                break;
        }
        return false;
    }
}

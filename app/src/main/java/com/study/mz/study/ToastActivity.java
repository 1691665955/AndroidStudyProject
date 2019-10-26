package com.study.mz.study;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;
import com.study.mz.study.util.ToastUtil;

public class ToastActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("Toast");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(ToastActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        setListener(new OnClick());
    }

    private void setListener(OnClick onClick) {
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(ToastActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(ToastActivity.this,"居中Toast",Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(ToastActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View toastView = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = toastView.findViewById(R.id.iv_toast);
                    imageView.setImageResource(R.drawable.smile);
                    TextView textView = toastView.findViewById(R.id.tv_toast);
                    textView.setText("自定义Toast");
                    toastCustom.setView(toastView);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(ToastActivity.this,"封装过的Toast");
                        break;
            }
        }
    }
}

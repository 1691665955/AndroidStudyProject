package com.study.mz.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.study.mz.study.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPopup;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnPopup = findViewById(R.id.btn_popup);
        mBtnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popupView = getLayoutInflater().inflate(R.layout.layout_popup,null);
                TextView tvGood = popupView.findViewById(R.id.tv_good);
                tvGood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPopupWindow.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this,"好");
                    }
                });
                mPopupWindow = new PopupWindow(popupView,mBtnPopup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setFocusable(true);
                mPopupWindow.showAsDropDown(mBtnPopup);
            }
        });
    }
}

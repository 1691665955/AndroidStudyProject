package com.study.mz.study;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;
import com.study.mz.study.util.ToastUtil;

public class PopupWindowActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private Button mBtnPopup;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("PopupWindow");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(PopupWindowActivity.this,getResources().getColor(R.color.colorPrimary),0);

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

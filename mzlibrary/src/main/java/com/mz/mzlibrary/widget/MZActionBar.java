package com.mz.mzlibrary.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mz.mzlibrary.R;

public class MZActionBar extends LinearLayout {

    private ImageView backView;
    private TextView titleView, menuView;
    private View headView;
    private LayoutInflater mInflater;

    public MZActionBar(Context context) {
        super(context);
        init(context);
    }

    public MZActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        mInflater = LayoutInflater.from(context);
        headView = mInflater.inflate(R.layout.action_bar_mz, null);
        addView(headView);
        initView();
    }

    private void initView() {
        backView = headView.findViewById(R.id.back_view);
        titleView = headView.findViewById(R.id.title_view);
        menuView = headView.findViewById(R.id.menu_view);
    }

    public void setStyle(String title) {
        if (title != null) {
            titleView.setText(title);
        }
    }

    public void setStyle(String title, String menuTitle, OnClickListener listener) {
        setStyle(title);
        if (menuTitle != null) {
            menuView.setText(menuTitle);
            menuView.setOnClickListener(listener);
        }
    }

    public void setStyle(String title, int menuResourceID, OnClickListener listener) {
        setStyle(title);
        menuView.setBackgroundResource(menuResourceID);
        menuView.setOnClickListener(listener);
    }

    public void setBackViewIcon(int backResourceID, OnClickListener listener) {
        backView.setImageResource(backResourceID);
        if (listener == null) {
            backView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity) getContext()).finish();
                }
            });
        } else {
            backView.setOnClickListener(listener);
        }
    }

    public void hiddenBackView(boolean hidden) {
        backView.setVisibility(hidden?GONE:VISIBLE);
    }
}

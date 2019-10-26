package com.study.mz.study;

import android.os.Bundle;
import android.util.Log;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class LifeCycleActivity extends MZBaseActivity {

    private MZActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("LifeCycle");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(LifeCycleActivity.this,getResources().getColor(R.color.colorPrimary),0);

        Log.d("LifeCycle","----onCreate----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","----onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","----onDestroy----");
    }

}

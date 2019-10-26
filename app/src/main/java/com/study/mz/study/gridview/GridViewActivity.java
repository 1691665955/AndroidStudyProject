package com.study.mz.study.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class GridViewActivity extends MZBaseActivity {
    private MZActionBar mActionBar;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("GridView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(GridViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mGridView = findViewById(R.id.gv);
        mGridView.setAdapter(new GridViewAdapter(GridViewActivity.this));
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "点击了"+(i+1)+"项", Toast.LENGTH_SHORT).show();
            }
        });
        mGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "长按了"+(i+1)+"项", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

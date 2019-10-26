package com.study.mz.study.recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class GridRecyclerViewActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("GridRecyclerView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(GridRecyclerViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(GridRecyclerViewActivity.this, "点击了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(GridRecyclerViewActivity.this, "长按了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}

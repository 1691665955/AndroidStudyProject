package com.study.mz.study.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class LinearRecyclerViewActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("LinearRecyclerView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(LinearRecyclerViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mRvMain = findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvMain.addItemDecoration(new MyDecoration());
        mRvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this, "点击了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this, "长按了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }

        }));
    }

    private class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}

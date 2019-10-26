package com.study.mz.study.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class PuRecycleViewActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycle_view);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("PuRecycleView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(PuRecycleViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mRvPu = findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new MyDecoration());
        mRvPu.setAdapter(new StaggeredGridAdaptar(PuRecycleViewActivity.this, new StaggeredGridAdaptar.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(PuRecycleViewActivity.this, "点击了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(PuRecycleViewActivity.this, "长按了第"+(position+1)+"行", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap,gap,gap,gap);
        }
    }

}

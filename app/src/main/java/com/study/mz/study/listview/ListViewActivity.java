package com.study.mz.study.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.R;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class ListViewActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private ListView mLv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("ListView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(ListViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mLv1 = findViewById(R.id.lv_1);
        mLv1.setAdapter(new MyListAdapter(ListViewActivity.this));
        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListViewActivity.this, "点击 pos:" + i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListViewActivity.this,MyListDetailActivity.class);
                startActivity(intent);
            }
        });
        mLv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "长按 pos:" + i, Toast.LENGTH_SHORT).show();
                //return ture or false (true代表事件已处理完 false代表接下来可以继续执行其他事件)
                return true;
            }
        });
    }
}

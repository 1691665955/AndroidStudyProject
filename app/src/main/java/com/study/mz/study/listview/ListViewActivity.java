package com.study.mz.study.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.study.mz.study.R;

public class ListViewActivity extends Activity {

    private ListView mLv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

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

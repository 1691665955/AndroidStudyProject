package com.study.mz.study.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.study.mz.study.R;

import java.util.ArrayList;

public class MyListDetailActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_detail);

        ArrayList<String> dataList = new ArrayList<String>();
        for (int i =0; i < 20; i++) {
            dataList.add("标题"+(i+1));
        }

        mListView = findViewById(R.id.listView);
        mListView.setAdapter(new MyListDetailAdapter(MyListDetailActivity.this,dataList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MyListDetailActivity.this, "点击第"+(i+1)+"个item", Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MyListDetailActivity.this, "长按第"+(i+1)+"个item", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

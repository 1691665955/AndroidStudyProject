package com.study.mz.study.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.mz.study.R;

import java.util.ArrayList;

public class MyListDetailAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mDataList;

    MyListDetailAdapter(Context context,ArrayList<String> dataList ) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvTitle,tvContent,tvTime;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view= mLayoutInflater.inflate(R.layout.layout_list_item_detail,null);
            viewHolder.imageView = view.findViewById(R.id.iv);
            viewHolder.tvTitle = view.findViewById(R.id.tv_title);
            viewHolder.tvContent = view.findViewById(R.id.tv_content);
            viewHolder.tvTime = view.findViewById(R.id.tv_time);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String string = mDataList.get(i);
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561971190192&di=2153345447c7427385e42370e1162e33&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F18%2F20150418H0215_AkXBt.jpeg").into(viewHolder.imageView);
        viewHolder.tvTitle.setText(string);
        viewHolder.tvContent.setText("我是内容我是内容我是内容我是内容我是内容我是内容");
        viewHolder.tvTime.setText("2019-07-02");
        return view;
    }
}

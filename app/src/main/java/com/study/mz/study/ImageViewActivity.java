package com.study.mz.study;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;
import com.mz.mzlibrary.MZBaseActivity;
import com.mz.mzlibrary.widget.MZActionBar;
import com.study.mz.study.boardcast.LocalBoardcastActivity;

public class ImageViewActivity extends MZBaseActivity {

    private MZActionBar mActionBar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mActionBar = findViewById(R.id.action_bar);
        mActionBar.setStyle("ImageView");
        mActionBar.setBackViewIcon(R.drawable.back,null);
        StatusBarUtil.setColor(ImageViewActivity.this,getResources().getColor(R.color.colorPrimary),0);

        mImageView = findViewById(R.id.iv_4);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561971190192&di=2153345447c7427385e42370e1162e33&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F18%2F20150418H0215_AkXBt.jpeg").into(mImageView);

    }
}

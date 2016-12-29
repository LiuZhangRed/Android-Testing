package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jerry.testing.R;
import com.example.jerry.testing.wedgit.CircleImageView;
import com.jaeger.library.StatusBarUtil;

public class InfoActivity extends BaseActivity {
    private CircleImageView image;
    private ImageView image_back;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        StatusBarUtil.setTransparent(this);
        mContext = this;

        initView();

    }
    private void initView() {
        image = (CircleImageView) findViewById(R.id.image);
        image_back=(ImageView)findViewById(R.id.image_back);
        image.setAlpha(100);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InfoActivity.this,MoreActivity.class);
                startActivity(intent);
            }
        });
    }
}

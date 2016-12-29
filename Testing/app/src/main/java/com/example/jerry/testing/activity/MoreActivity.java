package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jerry.testing.R;
import com.example.jerry.testing.ptr.PullToRefreshLayout;
import com.example.jerry.testing.ptr.RefreshLinstener;
import com.example.jerry.testing.wedgit.BilibiliHeader;
import com.jaeger.library.StatusBarUtil;

public class MoreActivity extends BaseActivity implements View.OnClickListener{
    private ImageView Iv_add;
    private ImageView Iv_info,image_back,Iv_collection;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        StatusBarUtil.setTransparent(this);
        mContext = this;
        initHead();
        Iv_info=(ImageView)findViewById(R.id.Iv_info);
        Iv_add=(ImageView)findViewById(R.id.Iv_add);
        Iv_add.setOnClickListener(this);
        Iv_info.setOnClickListener(this);
        final PullToRefreshLayout ptr = (PullToRefreshLayout) findViewById(R.id.ptrlayout);
        BilibiliHeader header = new BilibiliHeader(this);
        ptr.setHeader(header);

        ptr.setRefreshLinstener(new RefreshLinstener() {
            @Override
            public void onRefreshStart() {
                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptr.succeedRefresh();
                    }
                },2000);
            }
        });

    }
    private void initHead() {
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        ImageView Iv_collection= (ImageView) findViewById(R.id.collection);
        Iv_collection.setVisibility(View.GONE);
        image_back .setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Iv_info:
                Intent in = new Intent(MoreActivity.this, InfoActivity.class);
                startActivity(in);
                break;
            case R.id.Iv_add:
                Intent inS= new Intent(MoreActivity.this, AddHabitActivity.class);
                startActivity(inS);
                break;
        }
    }
}

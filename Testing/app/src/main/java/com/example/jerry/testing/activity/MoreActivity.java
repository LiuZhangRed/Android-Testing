package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.jerry.testing.R;

public class MoreActivity extends BaseActivity implements View.OnClickListener{
    private ImageView Iv_add;
    private ImageView Iv_info;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View view_title = (View) findViewById(R.id.view_title);
            view_title.setVisibility(View.VISIBLE);
            //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); （导航栏）
        }
        mContext = this;
        Iv_info=(ImageView)findViewById(R.id.Iv_info);
        Iv_add=(ImageView)findViewById(R.id.Iv_add);
        Iv_add.setOnClickListener(this);
        Iv_info.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Iv_info:
                Intent in = new Intent(MoreActivity.this, InfoActivity.class);
                startActivity(in);
                break;
        }
    }
}

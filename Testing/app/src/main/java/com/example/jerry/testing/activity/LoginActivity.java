package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.jerry.testing.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView weibo;
    private ImageView  qq;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        weibo = (ImageView ) findViewById(R.id.weibo);
        qq = (ImageView ) findViewById(R.id.qq);
        weibo.setOnClickListener(this);
        qq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weibo:
                Intent in=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
                break;
            case R.id.qq:
                Intent ins=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(ins);
                break;
        }
    }
}
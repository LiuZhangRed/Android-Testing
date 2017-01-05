package com.example.jerry.testing.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jerry.testing.R;
import com.jaeger.library.StatusBarUtil;

public class UpdataNicknameActivity extends BaseActivity {
private ImageView  image_back;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_nickname);
        mContext = this;
        StatusBarUtil.setTransparent(this);
        initHead();
    }
    private void initHead() {
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

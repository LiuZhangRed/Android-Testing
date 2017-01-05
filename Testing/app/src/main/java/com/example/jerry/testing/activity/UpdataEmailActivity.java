package com.example.jerry.testing.activity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.jerry.testing.R;
import com.jaeger.library.StatusBarUtil;

public class UpdataEmailActivity extends BaseActivity {
    private ImageView image_back;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_email);
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

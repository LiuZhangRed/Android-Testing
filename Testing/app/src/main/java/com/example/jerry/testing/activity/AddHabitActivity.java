package com.example.jerry.testing.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jerry.testing.R;
import com.jaeger.library.StatusBarUtil;

public class AddHabitActivity extends BaseActivity {
    private ImageView image_back,Iv_collection;
    private Context mContext;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        mContext = this;
        StatusBarUtil.setTransparent(this);

        initHead();
    }
    private void initHead() {
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        ImageView Iv_collection= (ImageView) findViewById(R.id.collection);
        TextView tv_title=(TextView)findViewById(R.id.tv_title) ;
        tv_title.setText("新的生活习惯");
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

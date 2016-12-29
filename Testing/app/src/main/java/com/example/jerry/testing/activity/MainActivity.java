package com.example.jerry.testing.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.jerry.testing.R;
import com.example.jerry.testing.wedgit.WaveAnimationView;
import com.jaeger.library.StatusBarUtil;


public class MainActivity extends BaseActivity {
    private long clickTime = 0; //记录第一次点击的时间
    private ImageView Iv_more;
    private Context mContext;
    private ImageView image_back,Iv_collection;

    private WaveAnimationView waveAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initHead();
        StatusBarUtil.setTransparent(this);
        Iv_more=(ImageView)findViewById(R.id.Iv_more);
        waveAnimationView = (WaveAnimationView)findViewById(R.id.pull_to_refresh_wave);
        Iv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MoreActivity.class);
                startActivity(intent);
            }
        });


        waveAnimationView.startAnimation();
    }

    private void initHead() {
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        ImageView Iv_collection= (ImageView) findViewById(R.id.collection);
        Iv_collection.setVisibility(View.GONE);
        image_back .setVisibility(View.GONE);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次后退键退出程序",
                    Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        waveAnimationView.stopAnimation();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        waveAnimationView.startAnimation();
    }
}

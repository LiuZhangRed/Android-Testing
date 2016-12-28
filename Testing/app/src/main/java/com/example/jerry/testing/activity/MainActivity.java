package com.example.jerry.testing.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.jerry.testing.R;

public class MainActivity extends BaseActivity {
    private long clickTime = 0; //记录第一次点击的时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View view_title = (View) findViewById(R.id.view_title);
            view_title.setVisibility(View.VISIBLE);
            //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); （导航栏）
        }
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

}

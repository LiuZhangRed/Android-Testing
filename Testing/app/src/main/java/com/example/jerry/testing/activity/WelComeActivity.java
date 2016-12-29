package com.example.jerry.testing.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.jerry.testing.R;

import java.util.Timer;
import java.util.TimerTask;


public class WelComeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.guide_a);
        getHomeActivity();
    }
   private void getHomeActivity() {
           Timer timer=new Timer();
       TimerTask task=new TimerTask(){
                  public void run(){
                        Intent intent = new Intent(WelComeActivity.this,LoginActivity.class);
                        startActivity(intent);
                      finish();
                      }
               };
            timer.schedule(task,5000);

         }



}

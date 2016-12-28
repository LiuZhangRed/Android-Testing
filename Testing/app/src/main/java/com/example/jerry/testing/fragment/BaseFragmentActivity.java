package com.example.jerry.testing.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class BaseFragmentActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	
	protected void finishAndBack()
	{
        this.finish();
	}
	
	public <T> void gotoActivity(Context context, Class<T> toActivity)
	{
		Intent intent = new Intent(context, toActivity);
 		startActivity(intent);
	}



}

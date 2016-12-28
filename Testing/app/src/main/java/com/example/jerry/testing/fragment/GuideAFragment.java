package com.example.jerry.testing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jerry.testing.R;


@SuppressLint("ValidFragment")
public class GuideAFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();
    private View v;
    private Context mContext;
    public GuideAFragment() {
        super();
    }

    /**
     * 覆盖此函数，先通过inflater inflate函数得到view最后返回
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        v = inflater.inflate(R.layout.guide_a, container, false);
        return v;
    }




}
